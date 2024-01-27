package com.school21.chat.repositiries;

import com.school21.chat.datasource.DataSource;
import com.school21.chat.models.Chatroom;
import com.school21.chat.models.Message;
import com.school21.chat.models.User;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MessageRepositoryImpl implements MessageRepository {

    javax.sql.DataSource dataSource;

    public MessageRepositoryImpl(javax.sql.DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Integer id) throws SQLException {
        final String SQL_QUERY = "SELECT * FROM bootcamp.message WHERE id = ?";
        Message message = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                message = new Message();
                message.setId(resultSet.getInt("id"));
                message.setAuthor(resultSet.getInt("author"));
                message.setUser(findUserById(message.getAuthor()));
                message.setRoom(resultSet.getInt("room"));
                message.setChatroom(findChatRoomById(message.getRoom()));
                message.setText(resultSet.getString("text"));
                message.setDate(resultSet.getTimestamp("time"));
            }
        }
        return Optional.ofNullable(message);
    }

    User findUserById(Integer id) throws SQLException {
        final String SQL_QUERY = "SELECT * FROM bootcamp.\"User\" WHERE id = ?";
        User user = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
            }
        }
        return user;
    }

    Chatroom findChatRoomById(Integer id) throws SQLException {
        final String SQL_QUERY = "SELECT * FROM bootcamp.chatroom WHERE id = ?";
        Chatroom chatroom = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                chatroom = new Chatroom();
                chatroom.setId(resultSet.getInt("id"));
                chatroom.setName(resultSet.getString("name"));
                chatroom.setOwner(resultSet.getInt("owner"));
            }
        }
        return chatroom;
    }
}

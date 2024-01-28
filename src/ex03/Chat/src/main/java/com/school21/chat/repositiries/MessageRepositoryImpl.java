package com.school21.chat.repositiries;

import com.school21.chat.exception.NotSavedSubEntityException;
import com.school21.chat.models.Chatroom;
import com.school21.chat.models.Message;
import com.school21.chat.models.User;

import java.sql.*;
import java.time.LocalDateTime;
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
                message.setAuthor(findUserById(resultSet.getInt("author")));
                message.setRoom(findChatRoomById(resultSet.getInt("room")));
                message.setText(resultSet.getString("text"));
                message.setDate(resultSet.getObject("time", LocalDateTime.class));
            }
        }
        return Optional.ofNullable(message);
    }

    @Override
    public void save(Message message) throws SQLException {
        Integer authorId = message.getAuthor().getId();
        Integer roomId = message.getRoom().getId();
        if (findUserById(authorId) == null || findChatRoomById(roomId) == null)
            throw new NotSavedSubEntityException();
        try (Connection connection = dataSource.getConnection();) {
            final String SQL_query = "INSERT INTO bootcamp.message(author,room,text,time) VALUES(" +
                    "?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, authorId);
            preparedStatement.setInt(2, roomId);
            preparedStatement.setString(3, message.getText());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(message.getDate()));
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                message.setId(resultSet.getInt("id"));
            }
        }
    }

    @Override
    public void update(Message message) throws SQLException {
        final String SQLQuery = "UPDATE bootcamp.message " +
                "SET author = ?,room = ?, text = ?, time = ? WHERE " +
                "id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery);) {
            preparedStatement.setInt(1, message.getAuthor().getId());
            preparedStatement.setInt(2, message.getRoom().getId());
            preparedStatement.setString(3, message.getText());
            preparedStatement.setTimestamp(4, message.getDate() == null ? Timestamp.valueOf(LocalDateTime.now()) : Timestamp.valueOf(message.getDate()));
            preparedStatement.setInt(5, message.getId());
            preparedStatement.executeUpdate();
        }
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
                chatroom.setUser(findUserById(resultSet.getInt("owner")));
            }
        }
        return chatroom;
    }
}

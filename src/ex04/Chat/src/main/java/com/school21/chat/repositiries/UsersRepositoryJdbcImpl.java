package com.school21.chat.repositiries;

import com.school21.chat.models.Chatroom;
import com.school21.chat.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryJdbcImpl implements UserRepository {

    javax.sql.DataSource dataSource;

    public UsersRepositoryJdbcImpl(javax.sql.DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> findAll(int page, int size) throws SQLException {
        List<User> userList = new ArrayList<>();
        final String SQlQuery = "WITH pages AS (\n" +
                "    SELECT u.id,cr.id AS created_room,ucr.chatroomid AS chatroom FROM bootcamp.\"User\" u\n" +
                "    FULL JOIN bootcamp.chatroom cr ON cr.owner = u.id\n" +
                "    FULL JOIN bootcamp.userchatroom ucr ON u.id = ucr.userid\n" +
                "),\n" +
                "position AS (\n" +
                "    SELECT u.id,ROW_NUMBER() OVER (ORDER BY u.id) AS position FROM bootcamp.\"User\" u\n" +
                ")\n" +
                "SELECT PAGES.id,PAGES.CREATED_ROOM,PAGES.CHATROOM,POSITION.POSITION - 1 AS position FROM  pages JOIN POSITION ON POSITION.id = PAGES.id " +
                " WHERE position >= ? AND position < ? ORDER BY position";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQlQuery);
            preparedStatement.setInt(1, (page * size) + 1);
            preparedStatement.setInt(2, (page + 1) * size + 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean flag_repeat = false;
            while (resultSet.next()) {
                User user = findUserById(resultSet.getInt("id"));
                if (!userList.isEmpty() && user.getId() == userList.getLast().getId()) {
                    user = userList.getLast();
                    flag_repeat = true;
                } else flag_repeat = false;
                Chatroom createdRoom = findChatRoomById(resultSet.getInt("created_room"));
                Chatroom chatroom = findChatRoomById(resultSet.getInt("chatroom"));
                if (createdRoom != null && !user.getCreatedRooms().contains(createdRoom))
                    user.addCreatedRooms(createdRoom);
                if (chatroom != null && !user.getSocialRooms().contains(chatroom)) user.addSocialRooms(chatroom);
                if (!flag_repeat) userList.add(user);
            }
        }
        return userList;
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

package com.school21.chat.app;

import com.school21.chat.datasource.DataSource;
import com.school21.chat.models.Message;
import com.school21.chat.models.User;
import com.school21.chat.repositiries.MessageRepository;
import com.school21.chat.repositiries.MessageRepositoryImpl;
import com.school21.chat.repositiries.UserRepository;
import com.school21.chat.repositiries.UsersRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {

        UserRepository messageRepository = new UsersRepositoryJdbcImpl(new DataSource().getDataSource());
        List<User> list = messageRepository.findAll(1, 2);
        for (User user : list) {
            System.out.println(user);
            System.out.println(user.getCreatedRooms());
            System.out.println(user.getSocialRooms());
            System.out.println("====================");

        }


    }
}
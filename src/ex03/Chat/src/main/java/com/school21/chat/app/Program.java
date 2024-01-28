package com.school21.chat.app;

import com.school21.chat.datasource.DataSource;
import com.school21.chat.models.Chatroom;
import com.school21.chat.models.Message;
import com.school21.chat.models.User;
import com.school21.chat.repositiries.MessageRepository;
import com.school21.chat.repositiries.MessageRepositoryImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {

        MessageRepository messageRepository = new MessageRepositoryImpl(new DataSource().getDataSource());
        Optional<Message> messageOptional = messageRepository.findById(16);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setText("I'm good!");
            message.setDate(null);
            messageRepository.update(message);
        }


//        User creator1 = new User(10,"antoinco","123",new ArrayList<>(),new ArrayList<>());
//        User author1 = creator1;
//        Chatroom room1 = new Chatroom(1,"C++ Chat",creator1,new ArrayList<>());
//        Message message1 = new Message(null,author1,room1,"Hello guys!", LocalDateTime.now());
//        MessageRepository messageRepository1 = new MessageRepositoryImpl(new DataSource().getDataSource());
//        messageRepository1.save(message1);
//        System.out.println(message1.getId());

    }
}
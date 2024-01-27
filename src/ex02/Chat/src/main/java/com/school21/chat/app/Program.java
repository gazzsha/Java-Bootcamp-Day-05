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
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        User creator = new User(1,"antoinco","123",new ArrayList<>(),new ArrayList<>());
        User author = creator;
        Chatroom room = new Chatroom(1,"C++ Chat",creator,new ArrayList<>());
        Message message = new Message(null,author,room,"Hello guys!", LocalDateTime.now());
        MessageRepository messageRepository = new MessageRepositoryImpl(new DataSource().getDataSource());
//        try (Scanner scanner = new Scanner(System.in)) {
//            System.out.println("Enter a message ID");
//            while (scanner.hasNext()) {
//                int id = scanner.nextInt();
//                Optional<Message> message = messageRepository.findById(id);
//                if (message.isPresent()) {
//                    System.out.println(message.get());
//                } else {
//                    System.out.println("Not found");
//                }
//                System.out.println("Enter a message ID");
//            }
//        } catch (SQLException ignored) {
//        }
    }
}
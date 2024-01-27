package com.school21.chat.repositiries;

import com.school21.chat.models.Message;

import java.sql.SQLException;
import java.util.Optional;

public interface MessageRepository {
    Optional<Message> findById(Integer id) throws SQLException;
    void save(Message message) throws SQLException;
}

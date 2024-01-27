package com.school21.chat.repositiries;

import com.school21.chat.models.Message;
import com.school21.chat.models.User;

import java.sql.SQLException;
import java.util.Optional;

public interface MessageRepository {
    Optional<Message> findById(Integer id) throws SQLException;

}

package com.school21.chat.repositiries;

import com.school21.chat.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    List<User> findAll(int page, int size) throws SQLException;
}

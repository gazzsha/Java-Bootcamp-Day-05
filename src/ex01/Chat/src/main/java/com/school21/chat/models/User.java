package com.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {

    private int id;
    private String login;

    private String password;

    private List<Chatroom> createdRooms;

    private List<Chatroom> socialRooms;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", socialRooms=" + socialRooms +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }


    public List<Chatroom> getSocialRooms() {
        return socialRooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!Objects.equals(login, user.login)) return false;
        if (!Objects.equals(password, user.password)) return false;
        if (!createdRooms.equals(user.createdRooms)) return false;
        return socialRooms.equals(user.socialRooms);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + createdRooms.hashCode();
        result = 31 * result + socialRooms.hashCode();
        return result;
    }
}

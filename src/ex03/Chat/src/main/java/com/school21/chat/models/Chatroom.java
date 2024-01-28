package com.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {

    private int id;
    private String name;

    private User user;

    List<Message> messages;

    public Chatroom() {
    }

    public Chatroom(int id, String name, User user, List<Message> messages) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "name='" + name + '\'' +
                ", messages=" + messages +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chatroom chatroom = (Chatroom) o;

        if (id != chatroom.id) return false;
        if (!Objects.equals(name, chatroom.name)) return false;
        if (!Objects.equals(user, chatroom.user)) return false;
        return Objects.equals(messages, chatroom.messages);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (messages != null ? messages.hashCode() : 0);
        return result;
    }
}

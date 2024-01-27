package com.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {

    private int id;
    private String name;

    private int owner;

    private User user;

    private List<User> socialUsers;
    List<Message> messages;

    public Chatroom() {
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "name='" + name + '\'' +
                ", owner=" + owner +
                ", user=" + user +
                ", socialUsers=" + socialUsers +
                ", messages=" + messages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chatroom chatroom = (Chatroom) o;

        if (id != chatroom.id) return false;
        if (owner != chatroom.owner) return false;
        if (!Objects.equals(name, chatroom.name)) return false;
        if (!Objects.equals(user, chatroom.user)) return false;
        if (!Objects.equals(socialUsers, chatroom.socialUsers))
            return false;
        return Objects.equals(messages, chatroom.messages);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + owner;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (socialUsers != null ? socialUsers.hashCode() : 0);
        result = 31 * result + (messages != null ? messages.hashCode() : 0);
        return result;
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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getSocialUsers() {
        return socialUsers;
    }


    public List<Message> getMessages() {
        return messages;
    }

}

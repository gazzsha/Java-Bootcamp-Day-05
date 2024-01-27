package com.school21.chat.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Message {

    private int id;

    private int author;

    private int room;

    private String text;

    private Timestamp date;

    private User user;

    private Chatroom chatroom;

    public Message() {
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

        Message message = (Message) o;

        if (id != message.id) return false;
        if (author != message.author) return false;
        if (room != message.room) return false;
        if (!Objects.equals(text, message.text)) return false;
        if (!Objects.equals(date, message.date)) return false;
        if (!Objects.equals(user, message.user)) return false;
        return Objects.equals(chatroom, message.chatroom);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + author;
        result = 31 * result + room;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (chatroom != null ? chatroom.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "\n id=" + id +
                ",\n user=" + user +
                ",\n chatroom=" + chatroom +
                ",\n text='" + text + '\'' +
                ",\n date=" + date +
                "\n }";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}

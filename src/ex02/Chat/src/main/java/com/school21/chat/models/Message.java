package com.school21.chat.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

    private int id;

    private User author;

    private Chatroom room;

    private String text;

    private LocalDateTime date;


    public Message() {
    }

    public Message(Integer id, User author, Chatroom room, String text, LocalDateTime date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
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
    public String toString() {
        return "Message{" +
                "\n id=" + id +
                ",\n user=" + author +
                ",\n chatroom=" + room +
                ",\n text='" + text + '\'' +
                ",\n date=" + date +
                "\n }";
    }



    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (!Objects.equals(author, message.author)) return false;
        if (!Objects.equals(room, message.room)) return false;
        if (!Objects.equals(text, message.text)) return false;
        return Objects.equals(date, message.date);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

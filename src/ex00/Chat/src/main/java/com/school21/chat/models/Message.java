package com.school21.chat.models;

import java.sql.Date;
import java.util.Objects;

public class Message {

    private int id;

    private int author;

    private int room;

    private String text;

    private Date date;

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "author=" + author +
                ", room=" + room +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
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
        return Objects.equals(date, message.date);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + author;
        result = 31 * result + room;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

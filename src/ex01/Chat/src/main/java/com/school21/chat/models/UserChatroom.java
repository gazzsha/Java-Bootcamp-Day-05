package com.school21.chat.models;

public class UserChatroom {

    private int user;
    private int chatroom;

    public UserChatroom() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserChatroom that = (UserChatroom) o;

        if (user != that.user) return false;
        return chatroom == that.chatroom;
    }

    @Override
    public int hashCode() {
        int result = user;
        result = 31 * result + chatroom;
        return result;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getChatroom() {
        return chatroom;
    }

    public void setChatroom(int chatroom) {
        this.chatroom = chatroom;
    }
}

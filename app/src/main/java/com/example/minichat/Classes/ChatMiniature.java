package com.example.minichat.Classes;

import java.io.Serializable;

public class ChatMiniature implements Serializable {
    Integer avatar;
    String username;
    String lastMsg;
    String date;

    public ChatMiniature(Integer avatar, String username, String lastMsg, String date) {
        this.avatar = avatar;
        this.username = username;
        this.lastMsg = lastMsg;
        this.date = date;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

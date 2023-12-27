package com.example.minichat.Classes;

public class User {
    private String first_name;
    private String last_name;
    private String username;
    private Integer age;
    private Integer avatar;

    public User() {}
    public User(String first_name, String last_name, String username) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }
}

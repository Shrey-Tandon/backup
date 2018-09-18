package com.example.user.firebase;

public class userReport {


    String username;
    String password;
    String uid;

    public userReport(String username, String password, String uid) {
        this.username = username;
        this.password = password;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public userReport() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

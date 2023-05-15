package com.roomup.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LoginDetails {

    @Id
    private String username;
    private String role;
    private String password;

//    public LoginDetails(String username, String password) {
//        this.username = username;
//        this.password = password;
//        this.role = "1";
//    }

    public LoginDetails() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

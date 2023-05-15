package com.roomup.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Admin {

    @Id
    @GeneratedValue
    private Long adminID;
    private String name;

    private String username;

    public Admin() {
    }

    public Admin(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

package com.roomup.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Block {

    @Id
    @GeneratedValue
    private Long blockID;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String gender;
    private String username;
    private String password;
    private String email;
    private String registeredID;

    public Block() {
    }

    public Block(String name, Date dob, String gender, String username, String password, String email, String registeredID) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registeredID = registeredID;

    }

    public Long getBlockID() {
        return blockID;
    }

    public void setBlockID(Long blockID) {
        this.blockID = blockID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisteredID() {
        return registeredID;
    }

    public void setRegisteredID(String registeredID) {
        this.registeredID = registeredID;
    }
}

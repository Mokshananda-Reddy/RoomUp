package com.roomup.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long studentID;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String gender;
    private String username;
    private String password;
    private String room;
    private String admissionID;
    private String email;
    public Student() {
    }

    public Student(String name, Date dob, String gender, String username, String password, String room, String admissionID, String email) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.room = room;
        this.admissionID = admissionID;
        this.email = email;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdmissionID() {
        return admissionID;
    }

    public void setAdmissionID(String admissionID) {
        this.admissionID = admissionID;
    }


}

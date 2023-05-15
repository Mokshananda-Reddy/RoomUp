package com.roomup.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue

    @Column(name = "taskid")
    private Long taskID;
    private Long studentID;
    private String service;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    private String feedback;
    private String room;


    public Task() {
    }

    public Task(String service, Date date,String description, String feedback, Long studentID, String room) {
        this.service = service;
        this.date = date;
        this.description = description;
        this.feedback = feedback;
        this.studentID = studentID;
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}

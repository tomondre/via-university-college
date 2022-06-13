package com.example.s07_networking.Ex02;

import java.time.LocalDateTime;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todos")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String text;
    private String createdOn;
    private boolean isDone;

    public Todo(String text, String createdOn, boolean isDone) {
        this.text = text;
        this.createdOn = createdOn;
        this.isDone = isDone;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}

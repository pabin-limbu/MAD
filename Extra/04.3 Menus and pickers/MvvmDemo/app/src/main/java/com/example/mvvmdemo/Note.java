package com.example.mvvmdemo;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

//this is a room annotationat compile time it will create all the necessary code
// to create sql lite table for this object.
@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private int priority;
    private String date;
    private String time;


    public Note(String title, String description, int priority,String date,String time) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.date = date;
        this.time=time;
    }
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}

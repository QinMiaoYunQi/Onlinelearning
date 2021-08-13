package com.javen.model;

import java.util.Date;

public class Topic {
    private int id;
    private String title;
    private int heat;
    private Date foundTime;
    private String studentName;

    public Date getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Date foundTime) {
        this.foundTime = foundTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", heat=" + heat +
                ", foundTime='" + foundTime + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}

package com.javen.model;

public class Title {
    private int id;
    private String comment;
    private String title;
    private String studentName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", title='" + title + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}

package com.javen.model;

import java.util.Date;

public class Homework {
    private int id;
    private String jobName;
    private String className;
    private Date date;
    private String teacherName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", className='" + className + '\'' +
                ", date=" + date +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}

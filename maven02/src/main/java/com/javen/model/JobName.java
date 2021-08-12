package com.javen.model;

public class JobName {
    private int id;
    private String studentName;
    private String fraction;
    private String jobName;
    private String className;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "JobName{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", fraction='" + fraction + '\'' +
                ", jobName='" + jobName + '\'' +
                ", className='" + className + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

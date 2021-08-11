package com.javen.model;

public class Correct {
    private Integer id;
    private String workName;
    private String studentName;
    private String content;
    private Integer point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Correct{" +
                "id=" + id +
                ", workName='" + workName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", content='" + content + '\'' +
                ", point=" + point +
                '}';
    }
}

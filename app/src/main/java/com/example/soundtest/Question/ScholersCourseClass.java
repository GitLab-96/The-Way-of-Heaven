package com.example.soundtest.Question;

public class ScholersCourseClass {
    private String title;
    private String schplarName;
    private String scholarTitle;
    private String coursetType;
    private String courseTime;
    private String courseDate;
    private String courseSubject;

    public ScholersCourseClass() {
    }

    public ScholersCourseClass(String title, String schplarName, String scholarTitle, String coursetType, String courseTime, String courseDate, String courseSubject) {
        this.title = title;
        this.schplarName = schplarName;
        this.scholarTitle = scholarTitle;
        this.coursetType = coursetType;
        this.courseTime = courseTime;
        this.courseDate = courseDate;
        this.courseSubject = courseSubject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSchplarName() {
        return schplarName;
    }

    public void setSchplarName(String schplarName) {
        this.schplarName = schplarName;
    }

    public String getScholarTitle() {
        return scholarTitle;
    }

    public void setScholarTitle(String scholarTitle) {
        this.scholarTitle = scholarTitle;
    }

    public String getCoursetType() {
        return coursetType;
    }

    public void setCoursetType(String coursetType) {
        this.coursetType = coursetType;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }

    public String getCourseSubject() {
        return courseSubject;
    }

    public void setCourseSubject(String courseSubject) {
        this.courseSubject = courseSubject;
    }
}

package com.example.soundtest.Question.Scholer;

import com.google.firebase.database.Exclude;

public class ScholersCourseClass {
    private String title;
    private String schplarName;
    private String scholarTitle;
    private String coursetType;
    private String courseStartTime;
    private String courseEndTime;
    private String courseDay;
    private String courseDate;
    private String courseSubject;

    private String Url;

    private String key;


    @Exclude
    public String getKey(){
        return key;
    }

    @Exclude
    public String setKey(String key){

        this.key = key;
        return key;
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

    public String getCourseStartTime() {
        return courseStartTime;
    }

    public void setCourseStartTime(String courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    public String getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(String courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public String getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(String courseDay) {
        this.courseDay = courseDay;
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

    public ScholersCourseClass(String title, String schplarName, String scholarTitle, String coursetType, String courseStartTime, String courseEndTime, String courseDay, String courseDate, String courseSubject) {
        this.title = title;
        this.schplarName = schplarName;
        this.scholarTitle = scholarTitle;
        this.coursetType = coursetType;
        this.courseStartTime = courseStartTime;
        this.courseEndTime = courseEndTime;
        this.courseDay = courseDay;
        this.courseDate = courseDate;
        this.courseSubject = courseSubject;
    }

    public ScholersCourseClass() {
    }

    public class ScholerLiveViewHolder {
    }
}

package com.example.soundtest.Question;

public class ScholarsLiveClass {
    private String title;
    private String schplarName;
    private String scholarTitle;
    private String livetType;
    private String liveStartTime;
    private String liveEndTime;
    private String liveDay;
    private String liveDate;
    private String liveSubject;

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

    public String getLivetType() {
        return livetType;
    }

    public void setLivetType(String livetType) {
        this.livetType = livetType;
    }

    public String getLiveStartTime() {
        return liveStartTime;
    }

    public void setLiveStartTime(String liveStartTime) {
        this.liveStartTime = liveStartTime;
    }

    public String getLiveEndTime() {
        return liveEndTime;
    }

    public void setLiveEndTime(String liveEndTime) {
        this.liveEndTime = liveEndTime;
    }

    public String getLiveDay() {
        return liveDay;
    }

    public void setLiveDay(String liveDay) {
        this.liveDay = liveDay;
    }

    public String getLiveDate() {
        return liveDate;
    }

    public void setLiveDate(String liveDate) {
        this.liveDate = liveDate;
    }

    public String getLiveSubject() {
        return liveSubject;
    }

    public void setLiveSubject(String liveSubject) {
        this.liveSubject = liveSubject;
    }

    public ScholarsLiveClass(String title, String schplarName, String scholarTitle, String livetType, String liveStartTime, String liveEndTime, String liveDay, String liveDate, String liveSubject) {
        this.title = title;
        this.schplarName = schplarName;
        this.scholarTitle = scholarTitle;
        this.livetType = livetType;
        this.liveStartTime = liveStartTime;
        this.liveEndTime = liveEndTime;
        this.liveDay = liveDay;
        this.liveDate = liveDate;
        this.liveSubject = liveSubject;
    }

    public ScholarsLiveClass() {
    }

    public class ScholerLiveViewHolder {
    }
}

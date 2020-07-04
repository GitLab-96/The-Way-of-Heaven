package com.example.soundtest.Question;

public class SettingDataClass  {

    private String name;
    private String email;
    private String phoneNo;
    private String gander;
    private String religion;
    private String nationality;
    private String DOB;
    private String aplicationDate;

    public SettingDataClass() {
    }

    public SettingDataClass(String name, String email, String phoneNo, String gander, String religion, String nationality, String DOB, String aplicationDate) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.gander = gander;
        this.religion = religion;
        this.nationality = nationality;
        this.DOB = DOB;
        this.aplicationDate = aplicationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAplicationDate() {
        return aplicationDate;
    }

    public void setAplicationDate(String aplicationDate) {
        this.aplicationDate = aplicationDate;
    }
}

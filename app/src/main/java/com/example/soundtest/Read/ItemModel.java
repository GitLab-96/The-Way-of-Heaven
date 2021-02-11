package com.example.soundtest.Read;

public class ItemModel {

    private String para;
    private String page;
    private String sura;
    private String ayatNumber;
    private String number;
    private String ayat;

    public ItemModel() {
    }

    public ItemModel(String para, String page, String sura, String ayatNumber, String number, String ayat) {
        this.para = para;
        this.page = page;
        this.sura = sura;
        this.ayatNumber = ayatNumber;
        this.number = number;
        this.ayat = ayat;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSura() {
        return sura;
    }

    public void setSura(String sura) {
        this.sura = sura;
    }

    public String getAyatNumber() {
        return ayatNumber;
    }

    public void setAyatNumber(String ayatNumber) {
        this.ayatNumber = ayatNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }
}

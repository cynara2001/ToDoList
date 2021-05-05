package com.example.todolist.db;

public class ToDo {

    int id;
    private static String mContent;
    private static int beginYear;
    private static int beginMonth;
    private static int beginDay;
    private static int overYear;
    private static int overMonth;
    private static int overDay;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getMContent() {
        return mContent;
    }

    public void setMContent(String mContent) {
        this.mContent = mContent;
    }

    public static int getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(int beginYear) {
        this.beginYear = beginYear;
    }

    public static int getBeginMonth() {
        return beginMonth;
    }

    public void setBeginMonth(int beginMonth) {
        this.beginMonth = beginMonth;
    }

    public static int getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(int beginDay) {
        this.beginDay = beginDay;
    }

    public static int getOverYear() {
        return overYear;
    }

    public void setOverYear(int overYear) {
        this.overYear = overYear;
    }

    public static int getOverMonth() {
        return overMonth;
    }

    public void setOverMonth(int overMonth) {
        this.overMonth = overMonth;
    }

    public static int getOverDay() {
        return overDay;
    }

    public void setOverDay(int overDay) {
        this.overDay = overDay;
    }


    public ToDo() {
    }

    public ToDo(String mContent, int beginYear, int beginMonth, int beginDay, int overYear, int overMonth, int overDay) {
        this.mContent = mContent;
        this.beginYear = beginYear;
        this.beginMonth = beginMonth;
        this.beginDay = beginDay;
        this.overYear = overYear;
        this.overMonth = overMonth;
        this.overDay = overDay;
    }
}

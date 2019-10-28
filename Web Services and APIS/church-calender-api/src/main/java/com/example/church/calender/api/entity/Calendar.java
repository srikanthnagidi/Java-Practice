package com.example.church.calender.api.entity;

import java.util.Date;
import java.util.List;

public class Calendar {
    private Date date;
    private String season;
    private int season_week;
    private List<Celebrations> celebrations;
    private String weekday;

    public Calendar() {
    }

    public Calendar(Date date, String season, int season_week, List<Celebrations> celebrations, String weekday) {
        this.date = date;
        this.season = season;
        this.season_week = season_week;
        this.celebrations = celebrations;
        this.weekday = weekday;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getSeason_week() {
        return season_week;
    }

    public void setSeason_week(int season_week) {
        this.season_week = season_week;
    }

    public List<Celebrations> getCelebrations() {
        return celebrations;
    }

    public void setCelebrations(List<Celebrations> celebrations) {
        this.celebrations = celebrations;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }
}

package com.example.church.calender.api.entity;

public class Celebrations {
    private String title;
    private String color;
    private String rank;
    private int rank_num;

    public Celebrations() {
    }

    public Celebrations(String title, String color, String rank, int rank_num) {
        this.title = title;
        this.color = color;
        this.rank = rank;
        this.rank_num = rank_num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getRank_num() {
        return rank_num;
    }

    public void setRank_num(int rank_num) {
        this.rank_num = rank_num;
    }
}

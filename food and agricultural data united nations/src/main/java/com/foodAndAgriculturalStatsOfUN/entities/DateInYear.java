package com.foodAndAgriculturalStatsOfUN.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "year")
public class DateInYear {
    @Id
    private int year;

    @OneToMany(mappedBy = "dateInYear", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Data> dataList  = new HashSet<>();

    public DateInYear(int year) {
        this.year = year;
    }

    public DateInYear() {
    }

    public Set<Data> getDataList() {
        return dataList;
    }

    public void setDataList(Set<Data> dataList) {
        this.dataList = dataList;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}

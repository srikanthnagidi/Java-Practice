package com.foodAndAgriculturalStatsOfUN.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "year")
public class DateInYear implements Comparable, Serializable {
    @Id
    private Integer year;

    @OneToMany(mappedBy = "dateInYear", orphanRemoval = true)
    private Set<Data> dataList  = new HashSet<>();

    public DateInYear(Integer year) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateInYear year1 = (DateInYear) o;
        return getYear().equals(year1.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear());
    }

    @Override
    public int compareTo(Object o) {
        DateInYear dateInYear = (DateInYear) o;
        return this.getYear().compareTo(dateInYear.getYear());
    }
}

package com.foodAndAgriculturalStatsOfUN.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country implements Comparable {

    @Id
    private String code;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.MERGE)
    private Set<Data> dataList = new HashSet<>();

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Data> getDataList() {
        return dataList;
    }

    public void setDataList(Set<Data> dataList) {
        this.dataList = dataList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return this.getCode().equals(country.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }
    @Override
    public int compareTo(Object o) {
        Country c = (Country) o;
        return this.getCode().compareTo(c.getCode());
    }
}

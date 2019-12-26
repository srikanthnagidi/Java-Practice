package com.foodAndAgriculturalStatsOfUN.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item implements Comparable, Serializable {
    @Id
    private String code;

    @Column(nullable = false)
    private String label;

    @OneToMany(mappedBy = "item", orphanRemoval = true)
    private Set<Data> dataList  = new HashSet<>();

    public Item(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public Item() {
    }

    public Set<Data> getDataList() {
        return dataList;
    }

    public void setDataList(Set<Data> dataList) {
        this.dataList = dataList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return this.getCode().equals(item.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    @Override
    public int compareTo(Object o) {
        Item item = (Item) o;
        return this.getCode().compareTo(((Item) o).getCode());
    }
}

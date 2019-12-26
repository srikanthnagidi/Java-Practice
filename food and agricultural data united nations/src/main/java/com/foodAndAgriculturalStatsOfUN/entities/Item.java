package com.foodAndAgriculturalStatsOfUN.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item {
    @Id
    private String code;

    @Column(nullable = false)
    private String label;

    @OneToMany(mappedBy = "item", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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

}

package com.foodAndAgriculturalStatsOfUN.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "elements")
public class Element {

    @Id
    private String id;

    @Column(nullable = false)
    private int code;
    @Column(nullable = false)
    private String label;

    @OneToMany(mappedBy = "element", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Data> dataList  = new HashSet<>();

    @Column
    private int groupd;

    public Element(int groupd, int code, String label) {
        this.id = String.valueOf(groupd) + code;
        this.groupd = groupd;
        this.code = code;
        this.label = label;
    }

    public Element() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Data> getDataList() {
        return dataList;
    }

    public void setDataList(Set<Data> dataList) {
        this.dataList = dataList;
    }

    public int getGroup() {
        return groupd;
    }

    public void setGroup(int group) {
        this.groupd = group;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getGroupd() {
        return groupd;
    }

    public void setGroupd(int groupd) {
        this.groupd = groupd;
    }
}

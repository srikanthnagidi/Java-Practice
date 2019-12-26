package com.foodAndAgriculturalStatsOfUN.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DataKey implements Serializable {

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "year")
    private Integer year;

    @Column(name = "element_id")
    private String id;

    @Override
    public String toString() {
        return "DataKey{" +
                "countryCode='" + countryCode + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", year=" + year +
                ", id='" + id + '\'' +
                '}';
    }

    public DataKey() {
    }

    public DataKey(String countryCode, String itemCode, int year, String id ){
        this.countryCode = countryCode;
        this.itemCode = itemCode;
        this.year = year;
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataKey dataKey = (DataKey) o;
        return getYear() == dataKey.getYear() &&
                Objects.equals(getCountryCode(), dataKey.getCountryCode()) &&
                Objects.equals(getItemCode(), dataKey.getItemCode()) &&
                Objects.equals(getId(), dataKey.getId());
    }

    @Override
    public int hashCode() {
        //return Objects.hash(getCountryCode(), getItemCode(), getYear(), getId());
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((countryCode == null) ? 0 : countryCode.hashCode());
        result = prime * result
                + ((itemCode == null) ? 0 : itemCode.hashCode());
        result = prime * result
                + ((year == 0) ? 0 : year.hashCode());
        result = prime * result
                + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}

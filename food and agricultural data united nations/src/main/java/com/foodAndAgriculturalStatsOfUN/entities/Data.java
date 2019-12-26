package com.foodAndAgriculturalStatsOfUN.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "datas")
public class Data {

   @EmbeddedId
   private DataKey id;

   @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   @MapsId("country_code")
   @JoinColumn(name = "country_code")
   private Country country;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("item_code")
    @JoinColumn(name = "item_code")
    private Item item;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("year")
    @JoinColumn(name = "year")
    private DateInYear dateInYear;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("element_id")
    @JoinColumn(name = "element_id")
    private Element element;

    private String unit;

    private BigDecimal value;

    private String flag;

    public Data(Country country, Item item, DateInYear dateInYear, Element element, String unit, BigDecimal value, String flag){
        this.id = new DataKey(country.getCode(), item.getCode(), dateInYear.getYear(), element.getId());
        this.country = country;
        this.item = item;
        this.dateInYear = dateInYear;
        this.element = element;
        this.unit = unit;
        this.value = value;
        this.flag = flag;

        country.getDataList().add(this);
        item.getDataList().add(this);
        element.getDataList().add(this);
        dateInYear.getDataList().add(this);
    }



    public Data() {
    }

    public DataKey getId() {
        return id;
    }

    public void setId(DataKey id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public DateInYear getDateInYear() {
        return dateInYear;
    }

    public void setDateInYear(DateInYear dateInYear) {
        this.dateInYear = dateInYear;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(getId(), data.getId()) &&
                Objects.equals(getCountry(), data.getCountry()) &&
                Objects.equals(getItem(), data.getItem()) &&
                Objects.equals(getDateInYear(), data.getDateInYear()) &&
                Objects.equals(getElement(), data.getElement()) &&
                Objects.equals(getUnit(), data.getUnit()) &&
                Objects.equals(getValue(), data.getValue()) &&
                Objects.equals(getFlag(), data.getFlag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry(), getItem(), getDateInYear(), getElement(), getUnit(), getValue(), getFlag());
    }
}

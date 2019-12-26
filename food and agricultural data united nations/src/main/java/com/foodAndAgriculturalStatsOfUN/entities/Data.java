package com.foodAndAgriculturalStatsOfUN.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "datas")
public class Data implements Serializable{

   @EmbeddedId
   private DataKey id;

   @ManyToOne(cascade = CascadeType.MERGE)
   @JoinColumn(name = "country_code", insertable = false, updatable = false)
   private Country country;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "item_code", insertable = false, updatable = false)
    private Item item;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "year", insertable = false, updatable = false)
    private DateInYear dateInYear;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "element_id", insertable = false, updatable = false)
    private Element element;

    @Column
    private String unit;

    @Column
    private BigDecimal value;

    @Column
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
        return this.getCountry().equals(data.getCountry()) &&
                this.getItem().equals(data.getItem()) &&
                this.getElement().equals(data.getElement()) &&
                this.getDateInYear().equals(data.getDateInYear()) &&
                this.getUnit().equals(data.getUnit()) &&
                this.getFlag().equals(data.getFlag()) &&
                this.getValue().equals(data.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry(), getItem(), getDateInYear(), getElement(), getUnit(), getValue(), getFlag());
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", country=" + country.getCode() +
                ", item=" + item.getLabel()+
                ", dateInYear=" + dateInYear.getYear() +
                ", element=" + element.getId() +
                ", unit='" + unit + '\'' +
                ", value=" + value +
                ", flag='" + flag + '\'' +
                '}';
    }
}

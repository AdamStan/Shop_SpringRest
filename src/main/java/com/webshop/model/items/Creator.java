package com.webshop.model.items;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Creator {
    @Id
    @GeneratedValue
    private Integer ID;
    private String country;
    private String type;
    @OneToMany(mappedBy = "creator")
    private Set<Item> items;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "ID=" + ID +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

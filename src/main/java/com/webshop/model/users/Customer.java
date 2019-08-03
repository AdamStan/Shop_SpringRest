package com.webshop.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webshop.model.order.Order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User {

    private String email;
    private String city;
    private String street;

    @Column(name = "number_of_building")
    private String numberOfBuilding;
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Order> orders;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberOfBuilding() {
        return numberOfBuilding;
    }

    public void setNumberOfBuilding(String numberOfBuilding) {
        this.numberOfBuilding = numberOfBuilding;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "Customer{" +
                "email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberOfBuilding='" + numberOfBuilding + '\'' +
                '}';
    }
}

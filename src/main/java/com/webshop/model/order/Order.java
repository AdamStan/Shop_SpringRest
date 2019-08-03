package com.webshop.model.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webshop.model.users.Customer;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
// https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer ID;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;
    @Column(name = "date_of_order")
    private Date dateOfOrder;
    private String city;
    private String street;
    @Column(name = "number_of_building")
    private String numberOfBuilding;
    @OneToMany(mappedBy = "orderObject")
    @JsonIgnore
    private Set<OrderToItem> orderToItems;

    public long getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
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

    public Set<OrderToItem> getOrderToItems() {
        return orderToItems;
    }

    public void setOrderToItems(Set<OrderToItem> orderToItems) {
        this.orderToItems = orderToItems;
    }
}

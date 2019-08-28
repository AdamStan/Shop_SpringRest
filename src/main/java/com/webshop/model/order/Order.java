package com.webshop.model.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webshop.model.users.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    @JsonIgnore
    private Customer customer;
    @Column(name = "date_of_order")
    private LocalDateTime dateOfOrder;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(name = "number_of_building", nullable = false)
    private String numberOfBuilding;
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
    @OneToMany(mappedBy = "orderObject")
    @JsonIgnore
    private Set<OrderToItem> orderToItems;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDateTime dateOfOrder) {
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

    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

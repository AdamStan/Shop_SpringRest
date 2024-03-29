package com.webshop.model.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webshop.model.order.OrderToItem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

/**
 * It will work with InheritanceType.JOINED but I want to try something new
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item {
    @Id
    @GeneratedValue
    private Integer ID;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private Creator creator;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "is_available")
    private Boolean isAvailable;
    @Column(nullable = false)
    private BigDecimal price;
    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private Set<OrderToItem> orderToItems;

    public Item(){

    }

    public Item(String name, String description, Creator creator, Date releaseDate, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.creator = creator;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Set<OrderToItem> getOrderToItems() {
        return orderToItems;
    }

    public void setOrderToItems(Set<OrderToItem> orderToItems) {
        this.orderToItems = orderToItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creator=" + creator +
                ", releaseDate=" + releaseDate +
                ", isAvailable=" + isAvailable +
                ", price=" + price +
                '}';
    }
}

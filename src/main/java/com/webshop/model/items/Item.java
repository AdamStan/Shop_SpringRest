package com.webshop.model.items;

import com.webshop.model.order.OrderToItem;
import org.postgresql.util.PGmoney;

import javax.persistence.*;
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
    private String description;
    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private Creator creator;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "is_available")
    private Boolean isAvailable;
    private PGmoney price;
    @OneToMany(mappedBy = "item")
    private Set<OrderToItem> orderToItems;

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

    public PGmoney getPrice() {
        return price;
    }

    public void setPrice(PGmoney price) {
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

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", description='" + description + '\'' +
                ", creator=" + creator +
                ", releaseDate=" + releaseDate +
                ", isAvailable=" + isAvailable +
                ", price=" + price +
                '}';
    }
}

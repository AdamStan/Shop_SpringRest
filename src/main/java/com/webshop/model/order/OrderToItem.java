package com.webshop.model.order;

import com.webshop.model.items.Item;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderToItem implements Serializable {
    @Id
    @GeneratedValue
    private Integer ID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "FK_to_order"))
    private Order orderObject;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "FK_to_item"))
    private Item item;

    private Integer amount;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrderObject() {
        return orderObject;
    }

    public void setOrderObject(Order orderObject) {
        this.orderObject = orderObject;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

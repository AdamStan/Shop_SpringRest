package com.webshop.model.users;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Seller extends User {

    @Column(name = "phone_number")
    private String phoneNumber;

    private String position;

    @GeneratedValue
    @Column(name = "seller_id", unique = true)
    private Integer sellerId;

    public String getPhone_number() {
        return phoneNumber;
    }

    public void setPhone_number(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSeller_id() {
        return sellerId;
    }

    public void setSeller_id(Integer seller_id) {
        this.sellerId = seller_id;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "Seller{" +
                "phone_number='" + phoneNumber + '\'' +
                ", position='" + position + '\'' +
                ", seller_id=" + sellerId +
                '}';
    }
}

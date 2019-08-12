package com.webshop.model;

import com.webshop.model.items.*;

import java.math.BigDecimal;
import java.sql.Date;

public class ItemFactory {
    public enum ItemTypes {
        BOOK, GAME, MOVIE, ITEM
    }

    /**
     * Creates item with these parameters:
     * @param type
     * type of item (item, book, movie or game)
     * @param name
     * name of item
     * @param description
     * description of item
     * @param creator
     * creator of item
     * @param date
     * date of item's release
     * @param price
     * price of item
     * @return
     * book, game, movie or item
     */
    public static Item createItem(ItemTypes type, String name, String description,
                                  Creator creator, Date date, BigDecimal price){
        switch (type) {
            case BOOK:
                return new Book(name, description, creator, date, price);
            case GAME:
                return new Game(name, description, creator, date, price);
            case MOVIE:
                return new Movie(name, description, creator, date, price);
            default:
                Item newItem = new Item(name, description, creator, date, price);
                return newItem;
        }
    }
}

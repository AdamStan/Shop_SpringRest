package com.webshop.model.items;

import org.postgresql.util.PGmoney;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Book extends Item {
    @Column(name = "number_of_sites")
    private Integer numberOfSites;

    @Column(name = "book_cover")
    private String bookCover;

    public Book() {

    }

    public Book(String name, String description, Creator creator, Date releaseDate, PGmoney price) {
        super(name, description, creator, releaseDate, price);
    }

    public Integer getNumberOfSites() {
        return numberOfSites;
    }

    public void setNumberOfSites(Integer numberOfSites) {
        this.numberOfSites = numberOfSites;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }
}

package com.webshop.model.items;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Book extends Item {
    @Column(name = "number_of_sites")
    private Integer numberOfSites;

    @Column(name = "book_cover")
    private String bookCover;

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

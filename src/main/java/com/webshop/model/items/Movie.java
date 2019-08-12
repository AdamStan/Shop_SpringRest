package com.webshop.model.items;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Movie extends Item{

    @Column(name = "main_actors")
    private String mainActors;

    private String carrier;

    @Column(name = "how_long_in_minutes")
    private Integer howLongInMinutes;

    public Movie() {
    }

    public Movie(String name, String description, Creator creator, Date releaseDate, BigDecimal price) {
        super(name, description, creator, releaseDate, price);
    }

    public String getMainActors() {
        return mainActors;
    }

    public void setMainActors(String mainActors) {
        this.mainActors = mainActors;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Integer getHowLongInMinutes() {
        return howLongInMinutes;
    }

    public void setHowLongInMinutes(Integer howLongInMinutes) {
        this.howLongInMinutes = howLongInMinutes;
    }
}

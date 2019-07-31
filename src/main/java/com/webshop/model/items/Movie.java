package com.webshop.model.items;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Movie extends Item{

    @Column(name = "main_actors")
    private String mainActors;

    private String carrier;

    @Column(name = "how_long_in_minutes")
    private Integer howLongInMinutes;

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

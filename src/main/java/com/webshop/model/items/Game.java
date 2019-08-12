package com.webshop.model.items;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Game extends Item {

    @Column(name = "video_game_genre")
    private String videoGameGenre;

    @Column(name = "how_long")
    private Long howLong;

    public Game() {
    }

    public Game(String name, String description, Creator creator, Date releaseDate, BigDecimal price) {
        super(name, description, creator, releaseDate, price);
    }

    public String getVideoGameGenre() {
        return videoGameGenre;
    }

    public void setVideoGameGenre(String videoGameGenre) {
        this.videoGameGenre = videoGameGenre;
    }

    public Long getHowLong() {
        return howLong;
    }

    public void setHowLong(Long howLong) {
        this.howLong = howLong;
    }
}

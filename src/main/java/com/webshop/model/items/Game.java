package com.webshop.model.items;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Game extends Item {

    @Column(name = "video_game_genre")
    private String videoGameGenre;

    @Column(name = "how_long")
    private Long howLong;

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

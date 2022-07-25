package com.sofka.cinema.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Billboard")
@Table(name = "billboard")
@Data
public class Billboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billboardId;
    private String theater;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Movie> movieList = new ArrayList<>();

    public Billboard() {
    }

    public Billboard(String theater) {
        this.theater = theater;
    }

}

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
    @SequenceGenerator(
            name = "billboard_sequence",
            sequenceName = "billboard_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "billboard_sequence"
    )
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

    public void addMovie(Movie movie){
        this.movieList.add(movie);
    }

}

package com.sofka.cinema.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity(name = "Movie")
@Table(name = "movie")
@Data
public class Movie {

    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Long movieId;
    private String movieName;
    private String director;
    private Long fkBillboardId;

    public Movie() {
    }

    public Movie(String movieName, String director, Long fkBillboardId) {
        this.movieName = movieName;
        this.director = director;
        this.fkBillboardId = fkBillboardId;
    }

    public Movie(String movieName, String director) {
        this.movieName = movieName;
        this.director = director;
    }
}

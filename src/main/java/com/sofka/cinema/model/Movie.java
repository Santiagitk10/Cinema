package com.sofka.cinema.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Movie")
@Table(name = "movie")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;
    private String movieName;
    private String director;
    private String genre;
    private Long durationMinutes;

}

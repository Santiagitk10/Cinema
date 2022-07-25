package com.sofka.cinema.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Billboard")
@Table(name = "billboard")
@Data
public class Billboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billboardId;
    private String theater;
    private List<Movie> movieList;

}

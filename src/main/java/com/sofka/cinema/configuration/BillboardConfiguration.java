package com.sofka.cinema.configuration;


import com.sofka.cinema.model.Billboard;
import com.sofka.cinema.model.Movie;
import com.sofka.cinema.repository.BillboardRepository;
import com.sofka.cinema.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BillboardConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(BillboardRepository billboardRepository){
        return args -> {
            Billboard saturday  = new Billboard("El Tesoro");
            Billboard sunday  = new Billboard("Viscaya");
            billboardRepository.saveAll(List.of(saturday, sunday));
        };
    };

}

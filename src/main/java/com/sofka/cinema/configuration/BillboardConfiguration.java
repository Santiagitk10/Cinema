package com.sofka.cinema.configuration;


import com.sofka.cinema.model.Billboard;
import com.sofka.cinema.repository.BillboardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BillboardConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(BillboardRepository repository){
        return args -> {
            Billboard saturday  = new Billboard("El Tesoro");

            Billboard sunday  = new Billboard("Viscaya");

            repository.saveAll(List.of(saturday, sunday));
        };
    };

}

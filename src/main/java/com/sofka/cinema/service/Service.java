package com.sofka.cinema.service;

import com.sofka.cinema.model.Billboard;
import com.sofka.cinema.model.Movie;
import com.sofka.cinema.repository.BillboardRepository;
import com.sofka.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {


    private BillboardRepository billboardRepository;
    private MovieRepository movieRepository;

    @Autowired
    public Service(BillboardRepository billboardRepository, MovieRepository movieRepository) {
        this.billboardRepository = billboardRepository;
        this.movieRepository = movieRepository;
    }

    public List<Billboard> getBillboards() {
        return billboardRepository.findAll();
    }

    public void addNewBillboard(Billboard billboard) {
        Optional<Billboard> billboardOptional = billboardRepository.findBillboardByTheater(billboard.getTheater());
        if(billboardOptional.isPresent()){
            throw new IllegalStateException(billboard.getTheater() + " already has a Billboard");
        }
        billboardRepository.save(billboard);
    }

    public void createMovie(Movie movie){
        Billboard billboard = billboardRepository.findById(movie.getFkBillboardId()).get();
        billboard.addMovie(movie);
        movieRepository.save(movie);
        billboardRepository.save(billboard);
    }


    public void deleteMovie(Long movieId){
        movieRepository.deleteById(movieId);
    }

    public void deleteBillboard(Long billboardId) {
        boolean exists = billboardRepository.existsById(billboardId);
        if(!exists){
            throw new IllegalStateException("The Billboard with id" + billboardId + " does no exit");
        }

        Billboard billboard = billboardRepository.findById(billboardId).get();
        if(billboard.getMovieList().size() > 0){
            billboard.getMovieList().forEach(movie -> movieRepository.deleteById(movie.getMovieId()));
        }

        billboardRepository.deleteById(billboardId);
    }

    @Transactional
    public void updateBillboard(Long billboardId, String theater) {
        boolean exists = billboardRepository.existsById(billboardId);
        if(!exists){
            throw new IllegalStateException("The Billboard with id " + billboardId + " does not exit");
        }

        Billboard foundBillboard = billboardRepository.findById(billboardId).get();

        if(theater.equals(foundBillboard.getTheater())){
            throw  new IllegalStateException("The Theater is the same, no modification performed");
        }

        Optional<Billboard> billboardOptional = billboardRepository.findBillboardByTheater(theater);

        if(billboardOptional.isPresent()){
            throw  new IllegalStateException(theater + " already has a Billboard");
        }

        foundBillboard.setTheater(theater);

    }
}

package com.sofka.cinema.controller;

import com.sofka.cinema.model.Billboard;
import com.sofka.cinema.model.Movie;
import com.sofka.cinema.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/cinema")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    public List<Billboard> getBillboards(){
        return service.getBillboards();
    }

    @PostMapping("create/billboard")
    public void createNewBillboard(@RequestBody Billboard billboard){
        service.addNewBillboard(billboard);
    }

    @PostMapping("create/movie")
    public void createNewMovie(@RequestBody Movie movie){
        service.createMovie(movie);
    }


    @DeleteMapping(path = "delete/movie/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId){
        service.deleteMovie(movieId);
    }

    @DeleteMapping(path = "delete/billboard/{billboardId}")
    public void deleteBillboard(@PathVariable("billboardId") Long billboardId){
        service.deleteBillboard(billboardId);
    }

    @PatchMapping(path = "{billboardId}")
    public void updateBillboard(@PathVariable("billboardId") Long billboardId,
                                @RequestParam() String theater){
        service.updateBillboard(billboardId,theater);
    }

}

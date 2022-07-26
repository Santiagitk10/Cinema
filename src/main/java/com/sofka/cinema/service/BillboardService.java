package com.sofka.cinema.service;

import com.sofka.cinema.model.Billboard;
import com.sofka.cinema.repository.BillboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BillboardService {


    private BillboardRepository billboardRepository;

    @Autowired
    public BillboardService(BillboardRepository billboardRepository) {
        this.billboardRepository = billboardRepository;
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

    public void deleteBillboard(Long billboardId) {
        boolean exists = billboardRepository.existsById(billboardId);
        if(!exists){
            throw new IllegalStateException("The Billboard with id" + billboardId + " does no exit");
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

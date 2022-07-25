package com.sofka.cinema.service;

import com.sofka.cinema.model.Billboard;
import com.sofka.cinema.repository.BillboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

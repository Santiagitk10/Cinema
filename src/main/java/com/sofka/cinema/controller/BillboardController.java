package com.sofka.cinema.controller;

import com.sofka.cinema.model.Billboard;
import com.sofka.cinema.service.BillboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/cinema")
public class BillboardController {

    private final BillboardService billboardService;

    @Autowired
    public BillboardController(BillboardService billboardService) {
        this.billboardService = billboardService;
    }

    @GetMapping
    public List<Billboard> getBillboards(){
        return billboardService.getBillboards();
    }

    @PostMapping
    public void createNewBillboard(@RequestBody Billboard billboard){
        billboardService.addNewBillboard(billboard);
    }

    @DeleteMapping(path = "{billboardId}")
    public void deleteBillboard(@PathVariable("billboardId") Long billboardId){
        billboardService.deleteBillboard(billboardId);
    }

    @PatchMapping(path = "{billboardId}")
    public void updateBillboard(@PathVariable("billboardId") Long billboardId,
                                @RequestParam() String theater){
        billboardService.updateBillboard(billboardId,theater);
    }

}

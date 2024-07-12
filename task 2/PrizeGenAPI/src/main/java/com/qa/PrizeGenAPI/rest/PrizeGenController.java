package com.qa.PrizeGenAPI.rest;

import com.qa.PrizeGenAPI.service.PrizeGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrizeGenController {

    @Autowired
    private PrizeGenService service;


    @GetMapping("/generatePrize/{accountNum}")
    public double generatePrize(@PathVariable String accountNum) {
        return this.service.genPrize(accountNum);
    }
}

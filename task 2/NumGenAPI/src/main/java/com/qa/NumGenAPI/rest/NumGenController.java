package com.qa.NumGenAPI.rest;

import com.qa.NumGenAPI.service.NumGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumGenController {

    @Autowired
    private NumGenService service;

    @GetMapping("/generateNumber")
    public String genNumber() {
        return this.service.genNumber();
    }
}

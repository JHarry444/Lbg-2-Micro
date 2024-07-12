package com.qa.AccountAPI.rest;

import com.qa.AccountAPI.persistence.Account;
import com.qa.AccountAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {


    @Autowired
    private AccountService service;


    @PostMapping("/register")
    public Account register(@RequestBody Account account) {
        return this.service.register(account);
    }


}

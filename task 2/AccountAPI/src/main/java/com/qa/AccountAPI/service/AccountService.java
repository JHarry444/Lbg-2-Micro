package com.qa.AccountAPI.service;

import com.qa.AccountAPI.persistence.Account;
import com.qa.AccountAPI.persistence.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AccountService {

    @Autowired
    private AccountRepo repo;

    private RestClient restClient = RestClient.create();

    public Account register(Account newAccount) {
        // add call to number generator
        String accountNumber = restClient
                .get()
                .uri("http://localhost:8083/generateNumber")
                .retrieve()
                .body(String.class);

        newAccount.setAccountNumber(accountNumber);
        // add call to prize calculator

        Double prize = restClient
                .get()
                .uri("http://localhost:8084/generatePrize/" + accountNumber)
                .retrieve()
                .body(Double.class);

        newAccount.setPrize(prize);
        return this.repo.save(newAccount);
    }
}


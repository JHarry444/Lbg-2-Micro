package com.qa.AccountAPI.service;

import com.netflix.discovery.EurekaClient;
import com.qa.AccountAPI.persistence.Account;
import com.qa.AccountAPI.persistence.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AccountService {

    @Autowired
    private AccountRepo repo;

    @Autowired
    private EurekaClient eurekaClient;

    private RestClient restClient = RestClient.create();

    public Account register(Account newAccount) {
        // add call to number generator
        String numGenUri = this.eurekaClient
                .getNextServerFromEureka("NumGenAPI", false)
                .getHomePageUrl();
        String accountNumber = restClient
                .get()
                .uri(numGenUri + "/generateNumber")
                .retrieve()
                .body(String.class);

        newAccount.setAccountNumber(accountNumber);
        // add call to prize calculator
        String prizeGenUri = this.eurekaClient
                .getNextServerFromEureka("PrizeGenAPI", false)
                .getHomePageUrl();
        Double prize = restClient
                .get()
                .uri(prizeGenUri + "/generatePrize/" + accountNumber)
                .retrieve()
                .body(Double.class);

        newAccount.setPrize(prize);
        return this.repo.save(newAccount);
    }
}


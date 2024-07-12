package com.qa.AccountAPI.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private String accountNumber;

    private String firstName;

    private String lastName;

    private double prize;

    public Account(String accountNumber, String firstName, String lastName, double prize) {
        super();
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.prize = prize;
    }

    public Account() {
        super();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }
}

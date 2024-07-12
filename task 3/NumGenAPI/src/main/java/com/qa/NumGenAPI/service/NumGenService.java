package com.qa.NumGenAPI.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumGenService {


    private char[] type = {'a', 'b', 'c'};

    private int[] length = {6, 8, 9};

    private Random rand = new Random();

    public String genNumber() {
        char accountType = type[rand.nextInt(3)];
        String output = "" + accountType;
        int numLength = this.length[rand.nextInt(3)];
        for (int i = 0; i < numLength; i++) {
            output += rand.nextInt(10);
        }
        return output;
    }

}

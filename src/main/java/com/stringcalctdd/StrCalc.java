package com.stringcalctdd;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class StrCalc {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String[] parts = numbers.split(",|\n");
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            int num = Integer.parseInt(part.trim());

            if (num < 0) {
                negatives.add(num);
            } else if (num <= 1000) {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return sum;
    }



}
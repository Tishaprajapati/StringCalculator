package com.stringcalctdd;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class StrCalc {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";  // default delimiters

        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            String delimiterPart = numbers.substring(2, delimiterEnd);

            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
                // e.g. //[***]
                delimiter = Pattern.quote(delimiterPart.substring(1, delimiterPart.length() - 1));
            } else {
                // e.g. //;
                delimiter = Pattern.quote(delimiterPart);
            }

            numbers = numbers.substring(delimiterEnd + 1);
        }


        String[] parts = numbers.split(delimiter);
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
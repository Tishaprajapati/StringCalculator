package com.stringcalctdd;

import java.util.regex.Pattern;

public class StrCalc {
//    public int add(String numbers) {
//        if (numbers == null || numbers.isEmpty()) {
//            return 0;
//        }
//
//        String[] parts = numbers.split(",|\n");
//        int sum = 0;
//        for (String part : parts) {
//            sum += Integer.parseInt(part.trim());
//        }
//
//        return sum;
//    }
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";  // default delimiters

        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = Pattern.quote(numbers.substring(2, delimiterEnd));  // escape special characters
            numbers = numbers.substring(delimiterEnd + 1);
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part.trim());
        }

        return sum;
    }


}
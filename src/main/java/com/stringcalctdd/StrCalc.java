package com.stringcalctdd;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class StrCalc {

public int add(String numbers) {
    if (numbers == null || numbers.isEmpty()) {
        return 0;
    }

    String delimiter = ",|\n";
    if (numbers.startsWith("//")) {
        int delimiterIndex = numbers.indexOf("\n");
        delimiter = Pattern.quote(numbers.substring(2, delimiterIndex));
        numbers = numbers.substring(delimiterIndex + 1);
    }

    String[] parts = numbers.split(delimiter);
    int sum = 0;
    List<Integer> negatives = new ArrayList<>();

    for (String part : parts) {
        int num = Integer.parseInt(part.trim());
        if (num < 0) {
            negatives.add(num);
        }
        sum += num;
    }

    if (!negatives.isEmpty()) {
        throw new IllegalArgumentException("Negatives not allowed: " + negatives);
    }

    return sum;
}


}
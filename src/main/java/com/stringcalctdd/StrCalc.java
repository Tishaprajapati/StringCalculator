package com.stringcalctdd;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
public class StrCalc {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        String numPart = numbers;

        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf("\n");
            String delimiterPart = numbers.substring(2, newlineIndex);

            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
                // Support multiple custom delimiters like //[***][%]
                List<String> delimiters = new ArrayList<>();
                Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(delimiterPart);
                while (m.find()) {
                    delimiters.add(Pattern.quote(m.group(1)));
                }
                delimiter = String.join("|", delimiters);
            } else {
                // Single-char delimiter
                delimiter = Pattern.quote(delimiterPart);
            }
            numPart = numbers.substring(newlineIndex + 1);
        }

        String[] parts = numPart.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                int num = Integer.parseInt(part.trim());
                if (num < 0) {
                    negatives.add(num);
                } else if (num <= 1000) {
                    sum += num;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return sum;
    }

}
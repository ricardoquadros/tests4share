package org.examples.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Return a phrase with the first letter capitalized
 */

public class CapitalizeWords {

    public String capitalizeWords1(String input) {
        StringBuilder capitalized = new StringBuilder();
        boolean capitalizeNext = true;

        for (char ch : input.toCharArray()) {
            if (Character.isWhitespace(ch) || ch == '!') {
                capitalizeNext = true;
                capitalized.append(ch);
            } else if (capitalizeNext) {
                capitalized.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                capitalized.append(Character.toLowerCase(ch));
            }
        }

        return capitalized.toString();
    }

    public String capitalizeWords2(String input) {
        return Arrays.stream(input.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}

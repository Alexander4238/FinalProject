package org.example.util;

import java.util.Optional;

public abstract class Validator {
    public static Optional<Integer> getValidInt(String input) {
        try {
            Integer result = Integer.parseInt(input);
            return Optional.of(result);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static Optional<Double> getValidDouble(String input) {
        try {
            Double result = Double.parseDouble(input);
            return Optional.of(result);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}

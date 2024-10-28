package org.example.util.random;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class RandomUtils {

    private RandomUtils() throws InstantiationException {
    }

    public static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static double getRandomDoubleInRange(double min, double max) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat format = new DecimalFormat("#.###", symbols);
        BigDecimal decimal = new BigDecimal(Math.random() * (max - min + 1) + min);
        String temp = format.format(decimal);
        return Double.valueOf(temp);
    }

    public static String getRandomStringFromArray(String[] strings) {
        return strings[getRandomIntInRange(0, strings.length - 1)];
    }

}

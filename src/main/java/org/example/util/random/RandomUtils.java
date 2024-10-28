package org.example.util.random;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class RandomUtils {

    private RandomUtils() throws InstantiationException {
    }

    public static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static double getRandomDoubleInRange(int min, int max) {
        DecimalFormat format = new DecimalFormat("#.###");
        BigDecimal decimal = new BigDecimal(Math.random() * (max - min + 1) + min);
        String temp = format.format(decimal);
        return Double.parseDouble(temp);
    }

    public static String getRandomStringFromArray(String[] strings) {
        return strings[getRandomIntInRange(0, strings.length - 1)];
    }

}

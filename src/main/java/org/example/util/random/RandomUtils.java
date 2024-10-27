package org.example.util.random;

public class RandomUtils {

    private RandomUtils() throws InstantiationException {
    }

    public static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static String getRandomStringFromArray(String[] strings) {
        return strings[getRandomIntInRange(0, strings.length - 1)];
    }

}

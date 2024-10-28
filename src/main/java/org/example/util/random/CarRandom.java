package org.example.util.random;

import org.example.models.Car;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.util.random.RandomUtils.getRandomIntInRange;
import static org.example.util.random.RandomUtils.getRandomStringFromArray;

public abstract class CarRandom {

    private static final int POWER_MIN = 100;
    private static final int POWER_MAX = 350;
    private static final int YEAR_MIN = 1950;
    private static final int YEAR_MAX = LocalDate.now().getYear();
    private static final String[] models = {"Toyota", "Honda", "Ford", "Chevrolet", "Nissan", "Lada"};

    public static List<Car> getRandomList(int listSize) {
        return Stream.generate(() ->
                        new Car.CarBuilder()
                                .setPower(getRandomIntInRange(POWER_MIN, POWER_MAX))
                                .setModel(getRandomStringFromArray(models))
                                .setYear(getRandomIntInRange(YEAR_MIN, YEAR_MAX))
                                .build())
                .limit(listSize)
                .collect(Collectors.toList());
    }
}
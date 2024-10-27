package org.example.util.random;
import org.example.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRandom {
    public static void main (String[] args) {
        int number = 15;

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            Car car = new Car.CarBuilder()
                    .setPower(getRandomPower())
                    .setModel(getRandomModel())
                    .setYear(getRandomYear()).
                    build();
            carList.add(car);
        }

//        for(Car car : carList) {
//            System.out.println(car.getPower());
//            System.out.println(car.getModel());
//            System.out.println(car.getYear());
//        }
    }

    public static List<Car> getRandomList(int listSize) {
        return Stream.generate(() ->
                        new Car.CarBuilder()
                                .setPower(getRandomPower())
                                .setModel(getRandomModel())
                                .setYear(getRandomYear())
                                .build())
                .limit(listSize)
                .collect(Collectors.toList());
    }

    private static int getRandomPower() {
        Random random = new Random();
        return random.nextInt(150) + 100;
    }

    private static String getRandomModel() {
        String[] models = {"Toyota", "Honda", "Ford", "Chevrolet", "Nissan", "Lada"};
        Random random = new Random();
        return models[random.nextInt(models.length)];
    }
    private static int getRandomYear() {
        Random random = new Random();
        return random.nextInt(30) + 1970;
    }
}
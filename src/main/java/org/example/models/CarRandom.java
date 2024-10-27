package org.example.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class CarRandom {
    public static void main (String[] args) {

        RandomSize randomSize = new RandomSize();
        int number = randomSize.randomNumber();

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
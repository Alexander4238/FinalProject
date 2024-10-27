package org.example;

import org.example.models.Car;
import org.example.repository.FileRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder().setModel("Audi A6").setPower(300).setYear(2021).build();
        Car car2 = new Car.CarBuilder().setModel("Audi A7").setPower(245).setYear(2022).build();
        Car car3 = new Car.CarBuilder().setModel("Audi A8").setPower(420).setYear(2023).build();
        Car car4 = new Car.CarBuilder().setModel("Audi RS").setPower(500).setYear(2024).build();

        List<Car> cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        System.out.println("cars:");
        printArray(cars);

        FileRepositoryImpl repository = new FileRepositoryImpl();
        repository.saveToFile(cars, "cars.out");

        List<Car> cars1 = repository.readFromFile("cars.out");
        System.out.println("cars:");
        printArray(cars1);
    }

    static void printArray(List<Car> cars) {
        int n = cars.size();
        Car car;
        for (Car value : cars) {
            System.out.println(value.getModel() + " " + value.getPower() + " " + value.getYear());
        }
    }

}
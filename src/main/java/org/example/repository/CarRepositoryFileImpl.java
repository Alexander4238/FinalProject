package org.example.repository;

import org.example.models.Car;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryFileImpl implements CarRepository {

    @Override
    public void saveToFile(List<Car> cars, String fileName) {

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(
                    // second arg true data to be written to the end of the file
                    new FileOutputStream(fileName, true));

            for (Car car : cars) {
                objectOutputStream.writeObject(car);
            }
            objectOutputStream.close();

        } catch (IOException e) {
            System.out.println("Fail to save file!");
        }
    }

    @Override
    public List<Car> readFirst(int countFromStart, String fileName) {
        List<Car> cars = new ArrayList<>();
        Car car;

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
            for (int j = 0; j < countFromStart; j++) {
                car = (Car) objectInputStream.readObject();
                cars.add(car);
            }
            objectInputStream.close();
        } catch (IOException e) {
            System.out.println("File read error!");
        } catch (ClassNotFoundException e) {
            System.out.println("File do not contain cars!");
        }
        return cars;
    }
}

package org.example.repository;

import org.example.models.Car;

import java.util.List;

public interface CarRepository {
    void saveToFile(List<Car> list, String fileName);

    List<Car> readFirst(int i, String fileName);
}

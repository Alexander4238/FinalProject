package org.example.repository;

import org.example.models.Car;

import java.util.List;

interface CarRepository {
    void saveToFile(List<Car> list, String fileName);

    List<Car> readFirst(int i, String fileName);
}

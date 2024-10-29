package org.example.models;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private int power;
    private String model;
    private int year;

    Car(CarBuilder carBuilder) {
        this.power = carBuilder.power;
        this.model = carBuilder.model;
        this.year = carBuilder.year;
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return power == car.power && year == car.year && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, model, year);
    }

    @Override
    public String toString() {
        return String.format("Машина: Модель: %s, Мощность: %d, Год: %d", getModel(), getPower(), getYear());
    }

    public static class CarBuilder {
        private int power;
        private String model;
        private int year;

        public CarBuilder setPower(int power) {
            this.power = power;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

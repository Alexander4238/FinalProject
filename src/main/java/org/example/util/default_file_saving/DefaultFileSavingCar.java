package org.example.util.default_file_saving;

public class DefaultFileSavingCar implements DefaultFileSavingStrategy {

    @Override
    public String getFileName() {
        return "cars.out";
    }
}

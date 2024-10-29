package org.example.ui.manual_input;

import org.example.models.Car;
import org.example.util.ScannerHolder;

import java.util.ArrayList;
import java.util.List;

public class ManualListCar implements ManualListSupplierStrategy {
    @Override
    public List getList(int size) {
        System.out.println("Мощность(л.с); Модель; Год выпуска");
        List<Car> newList = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            int power = 0;
            String model = null;
            int yearOfProduction = 1;

            System.out.println("введите мощность автомобиля");
            boolean stopBlock = true;
            while (stopBlock) {
                String dataEntry = ScannerHolder.get().nextLine();
                stopBlock = powerForCars(dataEntry);
                if (stopBlock) {
                    int a = Integer.parseInt(dataEntry);
                    power = a;
                    System.out.println("мощность автомобиля - " + power + " л.с.");
                    System.out.println();
                    stopBlock = false;
                } else {
                    System.out.println("вы ввели не верное значение для мощности");
                    System.out.println("введите число от 1 до 3000");
                    stopBlock = true;
                }
            }

            System.out.println("введите название автомобиля");
            stopBlock = true;
            while (stopBlock) {
                model = ScannerHolder.get().nextLine();
                if (model != null) {
                    //Проверка в названии автомобиля только латинские буквы и цифры.
                    String[] modelChar = model.split("");
                    boolean b = true;
                    for (String s : modelChar) {
                        if (!s.matches("[a-zA-Z0-9 ]")) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        if (model.length() < 50) {
                            System.out.println("название автомобиля - " + model);
                            stopBlock = false;
                        } else {
                            System.out.println("название автомобиля не корректно");
                            System.out.println("только латинские буквы и цифры не более 50 символов");
                        }
                    } else {
                        System.out.println("название автомобиля не корректно");
                        System.out.println("только латинские буквы и цифры не более 50 символов");
                    }
                }
            }

            System.out.println("введите год выпуска автомобиля");
            stopBlock = true;
            while (stopBlock) {
                String dataEntry = ScannerHolder.get().nextLine();
                stopBlock = yearOfCar(dataEntry);
                if (stopBlock) {
                    int a = Integer.parseInt(dataEntry);
                    yearOfProduction = a;
                    System.out.println("год выпуска - " + yearOfProduction);
                    System.out.println();
                    stopBlock = false;
                } else {
                    System.out.println("вы ввели не верное значение для года выпуска");
                    System.out.println("введите число от 1700 до 2024");
                    stopBlock = true;
                }

            }
            Car car = new Car.CarBuilder().setPower(power).setModel(model).setYear(yearOfProduction).build();
            System.out.println("занесли в список объект № " + i);
            newList.add(car);

        }
        return newList;
    }

    public boolean powerForCars(String strLine) {
        boolean b = true;
        String[] dataEntryArray = strLine.split("");
        for (String s : dataEntryArray) {
            if (s.matches("[0-9]")) {
            } else {
                b = false;
                break;
            }
        }
        if (b) {
            int a = Integer.parseInt(strLine);
            if (a > 0 && a < 3001) {
                return b;
            } else {
                b = false;
                return b;
            }
        } else {
            return b;
        }
    }

    public boolean yearOfCar(String strLine) {
        boolean b = true;
        String[] dataEntryArray = strLine.split("");
        for (String s : dataEntryArray) {
            if (s.matches("[0-9]")) {
            } else {
                b = false;
                break;
            }
        }
        if (b) {
            int a = Integer.parseInt(strLine);
            if (a > 1700 && a < 2024) {
                return b;
            } else {
                b = false;
                return b;
            }
        } else {
            return b;
        }
    }
}

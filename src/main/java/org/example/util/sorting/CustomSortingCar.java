package org.example.util.sorting;

import org.example.models.Car;
import org.example.util.ScannerHolder;
import org.example.util.Sort;
import org.example.util.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CustomSortingCar implements CustomSortingStrategy {
    @Override
    public void customSorting(List list) {
        List<Car> listCar = (List<Car>) list;
        int sortForCar = 1;
        boolean stopBlock = true;
        while (stopBlock) {
            System.out.println("по какому параметру сортировать список? 1.по мощности 2.названию 3.год выпуска");
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> choiceOpt = Validator.getValidInt(dataEntry);
            if (choiceOpt.isPresent() && choiceOpt.get() > 0 && choiceOpt.get() < 4) {
                sortForCar = Integer.parseInt(dataEntry);
                System.out.format("по %s", sortForCar == 1 ? "мощности" :
                        (sortForCar == 2 ? "названию" : "году выпуска"));
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение");
                stopBlock = true;
            }
        }
        switch (sortForCar) {
            case 1:
                Sort.mergeSort(listCar, Comparator.comparing(Car::getPower));
                break;
            case 2:
                Sort.mergeSort(listCar, Comparator.comparing(Car::getModel));
                break;
            case 3:
                Sort.mergeSort(listCar, Comparator.comparing(Car::getYear));
                break;
        }
        listCar.forEach(System.out::println);
    }
}

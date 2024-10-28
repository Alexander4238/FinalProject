package org.example.ui;

import org.example.models.Book;
import org.example.models.Car;
import org.example.models.RootCrop;
import org.example.util.ScannerHolder;
import org.example.util.Sort;
import org.example.util.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public abstract class CustomSorting {
    public static void customSortingOfCars(List<Car> listCar) {
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

    public static void customSortingOfBook(List<Book> listBook) {
        int sortForBook = 1;
        boolean stopBlock = true;
        while (stopBlock) {
            System.out.println("по какому параметру сортировать список? 1.автору 2.названию 3.количеству страниц");
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> choiceOpt = Validator.getValidInt(dataEntry);
            if (choiceOpt.isPresent() && choiceOpt.get() > 0 && choiceOpt.get() < 4) {
                sortForBook = Integer.parseInt(dataEntry);
                System.out.format("по %s", sortForBook == 1 ? "автору" :
                        (sortForBook == 2 ? "названию" : "количеству страниц"));
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение");
                stopBlock = true;
            }
        }
        switch (sortForBook) {
            case 1:
                Sort.mergeSort(listBook, Comparator.comparing(Book::getAuthor));
                break;
            case 2:
                Sort.mergeSort(listBook, Comparator.comparing(Book::getTitle));
                break;
            case 3:
                Sort.mergeSort(listBook, Comparator.comparing(Book::getPagesQuantity));
                break;
        }
        listBook.forEach(System.out::println);
    }

    public static void customSortingOfRootCrop(List<RootCrop> listRootCrop) {
        int sortForRootCrop = 1;
        boolean stopBlock = true;
        while (stopBlock) {
            System.out.println("по какому параметру сортировать список? 1.типу 2.весу 3.цвету");
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> choiceOpt = Validator.getValidInt(dataEntry);
            if (choiceOpt.isPresent() && choiceOpt.get() > 0 && choiceOpt.get() < 4) {
                sortForRootCrop = Integer.parseInt(dataEntry);
                System.out.format("по %s", sortForRootCrop == 1 ? "типу" :
                        (sortForRootCrop == 2 ? "весу" : "цвету"));
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение");
                stopBlock = true;
            }
        }
        switch (sortForRootCrop) {
            case 1:
                Sort.mergeSort(listRootCrop, Comparator.comparing(RootCrop::getType));
                break;
            case 2:
                Sort.mergeSort(listRootCrop, Comparator.comparing(RootCrop::getWeight));
                break;
            case 3:
                Sort.mergeSort(listRootCrop, Comparator.comparing(RootCrop::getColor));
                break;
        }
        listRootCrop.forEach(System.out::println);
    }

}

package org.example.userInput;

import org.example.models.*;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CustomSorting {
    public static void customSortingOfCars(Scanner sc, List<Car> listCar){
        System.out.println("по какому параметру сортировать список? 1.по мощности 2.названию 3.год выпуска");
        int sortForCar = 1;
        boolean stopBlock = true;
        while (stopBlock) {
            if(sc.hasNextInt()) {
                sortForCar = sc.nextInt();
                if(sortForCar < 1 || sortForCar > 3) {
                    System.out.println("вы ввели не верное значение");
                    System.out.println("(введите цифру 1-3): 1.по мощности 2.названию 3.год выпуска");
                } else {
                    System.out.format("по %s", sortForCar == 1 ? "мощности" :
                            (sortForCar == 2 ? "названию" : "году выпуска" ));
                    System.out.println();
                    stopBlock = false;
                }
            } else {
                System.out.println("вы ввели не верное значение для выбора");
                System.out.println("(введите цифру 1-3): 1.по мощности 2.названию 3.год выпуска");
                sc.next();
            }
        }
        switch (sortForCar) {
            case 1 : listCar.stream().sorted(Comparator.comparing(Car::getPower)).forEach(System.out::println);
                break;
            case 2 : listCar.stream().sorted(Comparator.comparing(Car::getModel)).forEach(System.out::println);
                break;
            case 3 : listCar.stream().sorted(Comparator.comparing(Car::getYear)).forEach(System.out::println);
                break;
        }
    }
    public static void customSortingOfBook(Scanner sc, List<Book> listBook){
        System.out.println("по какому параметру сортировать список? 1.автору 2.названию 3.количеству страниц");
        int sortForBook = 1;
        boolean stopBlock = true;
        while (stopBlock) {
            if(sc.hasNextInt()) {
                sortForBook = sc.nextInt();
                if(sortForBook < 1 || sortForBook > 3) {
                    System.out.println("вы ввели не верное значение");
                    System.out.println("(введите цифру 1-3): 1.автору 2.названию 3.количеству страниц");
                } else {
                    System.out.format("по %s", sortForBook == 1 ? "автору" :
                            (sortForBook == 2 ? "названию" : "количеству страниц" ));
                    System.out.println();
                    stopBlock = false;
                }
            } else {
                System.out.println("вы ввели не верное значение для выбора");
                System.out.println("(введите цифру 1-3): 1.автору 2.названию 3.количеству страниц");
                sc.next();
            }
        }
        switch (sortForBook) {
            case 1 : listBook.stream().sorted(Comparator.comparing(Book::getAuthor)).forEach(System.out::println);
                break;
            case 2 : listBook.stream().sorted(Comparator.comparing(Book::getTitle)).forEach(System.out::println);
                break;
            case 3 : listBook.stream().sorted(Comparator.comparing(Book::getPagesQuantity)).forEach(System.out::println);
                break;
        }


    }
    public static void customSortingOfRootCrop(Scanner sc, List<RootCrop> listRootCrop){
        System.out.println("по какому параметру сортировать список? 1.типу 2.весу 3.цвету");
        int sortForRootCrop = 1;
        boolean stopBlock = true;
        while (stopBlock) {
            if(sc.hasNextInt()) {
                sortForRootCrop = sc.nextInt();
                if(sortForRootCrop < 1 || sortForRootCrop > 3) {
                    System.out.println("вы ввели не верное значение");
                    System.out.println("(введите цифру 1-3): 1.типу 2.весу 3.цвету");
                } else {
                    System.out.format("по %s", sortForRootCrop == 1 ? "типу" :
                            (sortForRootCrop == 2 ? "весу" : "цвету" ));
                    System.out.println();
                    stopBlock = false;
                }
            } else {
                System.out.println("вы ввели не верное значение для выбора");
                System.out.println("(введите цифру 1-3): 1.типу 2.весу 3.цвету");
                sc.next();
            }
        }
        switch (sortForRootCrop) {
            case 1 : listRootCrop.stream().sorted(Comparator.comparing(RootCrop::getType)).forEach(System.out::println);
                break;
            case 2 : listRootCrop.stream().sorted(Comparator.comparing(RootCrop::getWeight)).forEach(System.out::println);
                break;
            case 3 : listRootCrop.stream().sorted(Comparator.comparing(RootCrop::getColor)).forEach(System.out::println);
                break;
        }


    }

}

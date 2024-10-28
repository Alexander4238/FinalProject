package ProjectAston.userInput;

import ProjectAston.models.Book;
import ProjectAston.models.Car;
import ProjectAston.models.RootCrop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    //тип класса
    static int classType = 0;

    //размер списка
    static int listSize = 0;


    public static void manualWorkWithList(Scanner sc){
        System.out.println("выберите тип класса(введите цифру 1-3): 1.Автомобиль  2.Книга  3.Корнеплод");
        boolean stopBlock = true;
        while (stopBlock) {
            if(sc.hasNextInt()) {
                classType = sc.nextInt();
                if(classType < 1 || classType > 3) {
                    System.out.println("вы ввели не верное значение для типа");
                    System.out.println("выберите тип класса(введите цифру 1-3): 1.Автомобиль  2.Книга  3.Корнеплод");
                } else {
                    System.out.println("тип выбран");
                    stopBlock = false;
                }
            } else {
                System.out.println("вы ввели не верное значение для типа");
                System.out.println("выберите тип класса(введите цифру 1-3): 1.Автомобиль  2.Книга  3.Корнеплод");
                sc.next();
            }
        }
        System.out.println("введите размер списка");
        stopBlock = true;
        while (stopBlock){
            if(sc.hasNextInt()) {
                listSize = sc.nextInt();
                sc.nextLine();
                if(listSize < 1 || listSize > 10) {
                    System.out.println("вы ввели не верное значение для списка");
                    System.out.println("за рамками 1-10");
                    System.out.println("Введите размер списка");
                } else {
                    System.out.println("размер списка - " + listSize);
                    stopBlock = false;
                }
            } else {
                System.out.println("вы ввели не верное значение для списка");
                System.out.println("только целые положительные числа");
                sc.next();
            }
        }

        System.out.println("начнем заполнять в следующем формате ...");
        switch (classType) {
            case 1 : System.out.println("Мощность(л.с); Модель; Год выпуска");
                break;
            case 2 : System.out.println("Автор; Название; Количество страниц");
                break;
            case 3 : System.out.println("Тип; Вес(кг.); Цвет");
                break;
        }

        if(classType == 1){
            List<Car> listCar = getListCar(sc, listSize);
            CustomSorting.customSortingOfCars(sc, listCar);
        } else if (classType == 2) {
            List<Book> listBook = getListBook(sc, listSize);
            CustomSorting.customSortingOfBook(sc, listBook);
        } else {
            List<RootCrop> listRootCrop = getListRootCrop(sc, listSize);
            CustomSorting.customSortingOfRootCrop(sc, listRootCrop);
        }

    }
    public static List<Car> getListCar(Scanner sc, int listSize) {
        List<Car> newList = new ArrayList<>();
        for (int i = 1; i <= listSize; i++) {
            int power = 0;
            String model = null;
            int yearOfProduction = 1;

            System.out.println("введите мощность автомобиля");
            boolean stopBlockInput = true;
            while (stopBlockInput) {
                if (sc.hasNextInt()) {
                    power = sc.nextInt();
                    sc.nextLine();
                    if(power > 0 && power < 3000) {
                        System.out.println("мощность автомобиля - " + power + " л.с.");
                        stopBlockInput = false;
                    } else {
                        System.out.println("мощность автомобиля за рамками 0-3000");
                    }
                } else {
                    System.out.println("вы ввели не в верном формате для мощности автомобиля");
                    sc.next();
                }
            }

            System.out.println("введите название автомобиля");
            stopBlockInput = true;
            while (stopBlockInput) {
                model = sc.nextLine();
                if (model != null) {
                    //Проверка в названии автомобиля только латинские буквы.
                    String[] modelChar = model.split("");
                    boolean b = true;
                    for(String s: modelChar){
                        if(!s.matches("[a-zA-Z0-9 ]")){
                            b = false;
                            break;
                        }
                    }
                    if(b){
                        System.out.println("название автомобиля - " + model);
                        stopBlockInput = false;
                    } else {
                        System.out.println("название автомобиля не корректно");
                        System.out.println("только латинские буквы и цифры");
                    }
                }
            }

            System.out.println("введите год выпуска автомобиля");
            stopBlockInput = true;
            while (stopBlockInput) {
                if (sc.hasNextInt()) {
                    yearOfProduction = sc.nextInt();
                    if (yearOfProduction < 2025 && yearOfProduction > 1700) {
                        System.out.println("год выпуска автомобиля - " + yearOfProduction);
                        stopBlockInput = false;
                    } else {
                        System.out.println("год выпуска за рамками 1700-2024");
                    }
                } else {
                    System.out.println("год выпуска не в int");
                    sc.next();
                }
            }
            Car car = new Car.CarBuilder().setPower(power).setModel(model).setYear(yearOfProduction).build();
            System.out.println("занесли в список объект № " + i);
            newList.add(car);

        }
        return newList;
    }
    public static List<Book> getListBook(Scanner sc, int listSize) {
        List<Book> newList = new ArrayList<>();
        for (int i = 1; i <= listSize; i++) {
            String author = null;
            String title = null;
            int pagesQuantity = 0;

            System.out.println("введите автора");
            boolean stopBlockInput = true;
            while (stopBlockInput) {
                author = sc.nextLine();
                if (author != null) {
                    //Проверка в названии только латинские буквы.
                    String[] authorChar = author.split("");
                    boolean b = true;
                    for(String s: authorChar){
                        if(!s.matches("[a-zA-Z ]")){
                            b = false;
                            break;
                        }
                    }
                    if(b){
                        System.out.println("автор - " + author);
                        stopBlockInput = false;
                    } else {
                        System.out.println("автора ввели не корректно");
                        System.out.println("только латинские буквы");
                    }
                }
            }

            System.out.println("введите название книги");
            stopBlockInput = true;
            while (stopBlockInput) {
                title = sc.nextLine();
                if (title != null) {
                    System.out.println("название книги - " + title);
                    stopBlockInput = false;
                }
            }

            System.out.println("введите количество страниц");
            stopBlockInput = true;
            while (stopBlockInput) {
                if (sc.hasNextInt()) {
                    pagesQuantity = sc.nextInt();
                    if (pagesQuantity < 10000 && pagesQuantity > 0) {
                        System.out.println("количество страниц - " + pagesQuantity);
                        stopBlockInput = false;
                    } else {
                        System.out.println("количество страниц 0-10000");
                    }
                } else {
                    System.out.println("количество страниц не корректно");
                    sc.next();
                }
            }
            Book book = new Book.BookBuilder().author(author).title(title).pagesQuantity(pagesQuantity).build();
            System.out.println("занесли в список объект № " + i);
            newList.add(book);

        }
        return newList;
    }
    public static List<RootCrop> getListRootCrop(Scanner sc, int listSize) {
        List<RootCrop> newList = new ArrayList<>();
        for (int i = 1; i <= listSize; i++) {
            String type = null;
            double weight = 0.0;
            String color = null;

            System.out.println("введите тип корнеплода");
            boolean stopBlockInput = true;
            while (stopBlockInput) {
                type = sc.nextLine();
                if (type != null) {
                    //Проверка в названии только латинские буквы и цифры.
                    String[] authorChar = type.split("");
                    boolean b = true;
                    for(String s: authorChar){
                        if(!s.matches("[a-zA-Z0-9 ]")){
                            b = false;
                            break;
                        }
                    }
                    if(b){
                        System.out.println("тип - " + type);
                        stopBlockInput = false;
                    } else {
                        System.out.println("тип ввели не корректно");
                        System.out.println("только латинские буквы и цифры");
                    }
                }
            }

            System.out.println("введите вес в кг.");
            stopBlockInput = true;
            while (stopBlockInput) {
                if (sc.hasNextDouble()) {
                    weight = sc.nextDouble();
                    sc.nextLine();
                    if(weight > 0 && weight < 1000) {
                        System.out.println("вес - " + weight + " кг.");
                        stopBlockInput = false;
                    } else {
                        System.out.println("вес ввели не корректно");
                        System.out.println("вес за рамками 0-1000");
                    }
                } else {
                    System.out.println("вы ввели не в верном формате для вес");
                    sc.next();
                }
            }

            System.out.println("введите цвет");
            stopBlockInput = true;
            while (stopBlockInput) {
                color = sc.nextLine();
                if (color != null) {
                    //Проверка в названии только латинские буквы и цифры.
                    String[] authorChar = type.split("");
                    boolean b = true;
                    for(String s: authorChar){
                        if(!s.matches("[a-zA-Z0-9 ]")){
                            b = false;
                            break;
                        }
                    }
                    if(b){
                        System.out.println("цвет - " + color);
                        stopBlockInput = false;
                    } else {
                        System.out.println("цвет ввели не корректно");
                        System.out.println("только латинские буквы и цифры");
                    }
                }
            }

            RootCrop rootCrop = new RootCrop.RootCropBuilder().setType(type).setWeight(weight).setColor(color).build();
            System.out.println("занесли в список объект № " + i);
            newList.add(rootCrop);
        }
        return newList;
    }

}

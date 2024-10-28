package org.example.userInput;

import org.example.models.Book;
import org.example.models.Car;
import org.example.models.RootCrop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    //тип класса
    static int classType = 0;

    //размер списка
    static int listSize = 0;

    public static boolean onlyOneNumber(String strLine) {
        boolean b = true;
        String[] dataEntryArray = strLine.split("");
        for (String s : dataEntryArray) {
            if (s.matches("[1-3]")) {
            } else {
                b = false;
                break;
            }
        }
        if (b) {
            int a = Integer.parseInt(strLine);
            if (a > 0 && a < 4) {
                return b;
            } else {
                b = false;
                return b;
            }
        } else {
            return b;
        }
    }

    public static boolean listSize(String strLine) {
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
            if (a > 0 && a < 11) {
                return b;
            } else {
                b = false;
                return b;
            }
        } else {
            return b;
        }
    }

    public static boolean powerForCars(String strLine) {
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

    public static boolean yearOfCar(String strLine) {
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

    public static boolean pagesQuantityForBooks(String strLine) {
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
            if (a > 0 && a < 5001) {
                return b;
            } else {
                b = false;
                return b;
            }
        } else {
            return b;
        }
    }

    public static boolean weightRootCrop(String strLine) {
        boolean b = true;
        String[] dataEntryArray = strLine.split("");
        for (String s : dataEntryArray) {
            if (s.matches("[0-9.]")) {
            } else {
                b = false;
                break;
            }
        }
        if (b) {
            double a = Double.parseDouble(strLine);
            if (a > 0 && a < 1001) {
                return b;
            } else {
                b = false;
                return b;
            }
        } else {
            return b;
        }
    }


    public static void manualWorkWithList(Scanner sc) {
        System.out.println("выберите тип класса(введите цифру 1-3): 1.Автомобиль  2.Книга  3.Корнеплод");
        boolean stopBlock = true;
        while (stopBlock) {
            String dataEntry = sc.nextLine();
            stopBlock = onlyOneNumber(dataEntry);
            if (stopBlock) {
                int a = Integer.parseInt(dataEntry);
                classType = a;
                System.out.format("тип выбран %s", (a == 1 ? "Автомобиль" : (a == 2 ? "Книга" : "Корнеплод")));
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение для типа");
                System.out.println("выберите тип класса(введите цифру 1-3): 1.Автомобиль  2.Книга  3.Корнеплод");
                stopBlock = true;
            }
        }
        System.out.println("введите размер списка");
        stopBlock = true;
        while (stopBlock) {
            String dataEntry = sc.nextLine();
            stopBlock = listSize(dataEntry);
            if (stopBlock) {
                int a = Integer.parseInt(dataEntry);
                listSize = a;
                System.out.println("размер списка - " + listSize);
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение для списка");
                System.out.println("введите размер списка от 1 до 10 (размер для теста)");
                stopBlock = true;
            }

        }
        System.out.println("начнем заполнять в следующем формате ...");
        switch (classType) {
            case 1:
                System.out.println("Мощность(л.с); Модель; Год выпуска");
                break;
            case 2:
                System.out.println("Автор; Название; Количество страниц");
                break;
            case 3:
                System.out.println("Тип; Вес(кг.); Цвет");
                break;
        }

        if (classType == 1) {
            List<Car> listCar = getListCar(sc, listSize);
            CustomSorting.customSortingOfCars(sc, listCar);
            //Сохранить сортированный список listCar в базу и написать об этом
        } else if (classType == 2) {
            List<Book> listBook = getListBook(sc, listSize);
            CustomSorting.customSortingOfBook(sc, listBook);
            //Сохранить сортированный список listBook в базу и написать об этом
        } else {
            List<RootCrop> listRootCrop = getListRootCrop(sc, listSize);
            CustomSorting.customSortingOfRootCrop(sc, listRootCrop);
            //Сохранить сортированный список listRootCrop в базу и написать об этом1
        }

    }

    public static List<Car> getListCar(Scanner sc, int listSize) {
        List<Car> newList = new ArrayList<>();
        for (int i = 1; i <= listSize; i++) {
            int power = 0;
            String model = null;
            int yearOfProduction = 1;

            System.out.println("введите мощность автомобиля");
            boolean stopBlock = true;
            while (stopBlock) {
                String dataEntry = sc.nextLine();
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
                model = sc.nextLine();
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
                String dataEntry = sc.nextLine();
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
                    for (String s : authorChar) {
                        if (!s.matches("[a-zA-Z ]")) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        if (author.length() < 50) {
                            System.out.println("автор - " + author);
                            stopBlockInput = false;
                        } else {
                            System.out.println("автора ввели не корректно");
                            System.out.println("только латинские буквы не более 50 символов");
                        }
                    } else {
                        System.out.println("автора ввели не корректно");
                        System.out.println("только латинские буквы не более 50 символов");
                    }
                }
            }

            System.out.println("введите название книги");
            stopBlockInput = true;
            while (stopBlockInput) {
                title = sc.nextLine();
                if (title != null) {
                    //Проверка в названии только латинские буквы.
                    String[] titleChar = title.split("");
                    boolean b = true;
                    for (String s : titleChar) {
                        if (!s.matches("[a-zA-Z0-9 ]")) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        if (title.length() < 50) {
                            System.out.println("название книги - " + title);
                            stopBlockInput = false;
                        } else {
                            System.out.println("название книги ввели не корректно");
                            System.out.println("только латинские буквы и цифры не более 50 символов");
                        }
                    } else {
                        System.out.println("название книги ввели не корректно");
                        System.out.println("только латинские буквы и цифры не более 50 символов");
                    }
                }
            }

            System.out.println("введите количество страниц");
            stopBlockInput = true;
            while (stopBlockInput) {
                String dataEntry = sc.nextLine();
                stopBlockInput = pagesQuantityForBooks(dataEntry);
                if (stopBlockInput) {
                    int a = Integer.parseInt(dataEntry);
                    pagesQuantity = a;
                    System.out.println("количество страниц - " + pagesQuantity);
                    System.out.println();
                    stopBlockInput = false;
                } else {
                    System.out.println("вы ввели не верное значение для количество страниц");
                    System.out.println("введите число от 1 до 5000");
                    stopBlockInput = true;
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
                    //Проверка в названии автомобиля только латинские буквы и цифры.
                    String[] typeChar = type.split("");
                    boolean b = true;
                    for (String s : typeChar) {
                        if (!s.matches("[a-zA-Z0-9 ]")) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        if (type.length() < 50) {
                            System.out.println("тип корнеплода - " + type);
                            stopBlockInput = false;
                        } else {
                            System.out.println("название типа корнеплода не корректно");
                            System.out.println("только латинские буквы и цифры не более 50 символов");
                        }
                    } else {
                        System.out.println("название типа корнеплода не корректно");
                        System.out.println("только латинские буквы и цифры не более 50 символов");
                    }
                }
            }

            System.out.println("введите вес корнеплода в кг.");
            stopBlockInput = true;
            while (stopBlockInput) {
                String dataEntry = sc.nextLine();
                stopBlockInput = weightRootCrop(dataEntry);
                if (stopBlockInput) {
                    double a = Double.parseDouble(dataEntry);
                    weight = a;
                    System.out.println("вес корнеплода - " + weight + " кг.");
                    System.out.println();
                    stopBlockInput = false;
                } else {
                    System.out.println("вы ввели не верный вес корнеплода");
                    System.out.println("введите число от 1.0 до 1000.0");
                    stopBlockInput = true;
                }
            }

            System.out.println("введите цвет");
            stopBlockInput = true;
            while (stopBlockInput) {
                color = sc.nextLine();
                if (color != null) {
                    //Проверка в названии только латинские буквы и цифры.
                    String[] colorChar = color.split("");
                    boolean b = true;
                    for (String s : colorChar) {
                        if (!s.matches("[a-zA-Z0-9 ]")) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        if (color.length() < 50) {
                            System.out.println("цвет корнеплода - " + color);
                            stopBlockInput = false;
                        } else {
                            System.out.println("цвет корнеплода не корректен");
                            System.out.println("только латинские буквы и цифры не более 50 символов");
                        }
                    } else {
                        System.out.println("цвет корнеплода не корректен");
                        System.out.println("только латинские буквы и цифры не более 50 символов");
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

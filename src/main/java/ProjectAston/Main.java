package ProjectAston;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import ProjectAston.TypesOfSorting.SortingForCars.*;

import static java.util.regex.Pattern.matches;


public class Main {
    public static void main(String[] args) {
        //тип класса
        int classType = 0;

        //размер списка
        int listSize = 0;

        //как работать со списком
        int listForWork = 0;

        System.out.println("выберите как работать со списком(введите цифру 1-3): 1.вручную  2.из файла  3.рандом");
        Scanner sc = new Scanner(System.in);
        boolean stopBlock = true;
        while (stopBlock) {
            if(sc.hasNextInt()) {
                listForWork = sc.nextInt();
                if(listForWork < 1 || listForWork > 3) {
                    System.out.println("вы ввели не верное значение для работы со списком");
                    System.out.println("введите цифру 1-3: 1.вручную  2.из файла  3.рандом");
                } else {
                    System.out.format("ок способ выбран %s", listForWork == 1 ? "вручную" :
                            (listForWork == 2 ? "из файла" : "рандом" ));
                    System.out.println();
                    stopBlock = false;
                }
            } else {
                System.out.println("вы ввели не верное значение для работы со списком");
                System.out.println("введите цифру 1-3: 1.вручную  2.из файла  3.рандом");
                sc.next();
            }
        }
        if(listForWork == 1){
            System.out.println("выберите тип класса(введите цифру 1-3): 1.Автомобиль  2.Книга  3.Корнеплод");
            stopBlock = true;
            while (stopBlock) {
                if(sc.hasNextInt()) {
                    classType = sc.nextInt();
                    if(classType < 1 || classType > 3) {
                        System.out.println("вы ввели не верное значение для типа");
                        System.out.println("выберите тип класса(введите цифру 1-3): 1.Автомобиль  2.Книга  3.Корнеплод");
                    } else {
                        System.out.println("ок тип выбран");
                        stopBlock = false;
                    }
                } else {
                    System.out.println("вы ввели не верное значение для типа");
                    System.out.println("выберите тип класса(введите цифру 1-3): 1.Автомобиль  2.Книга  3.Корнеплод");
                    sc.next();
                }
            }

            System.out.println("введите размер списка от 1 до 10");
            stopBlock = true;
            while (stopBlock){
                if(sc.hasNextInt()) {
                    listSize = sc.nextInt();
                    if(listSize < 1 || listSize > 10) {
                        System.out.println("вы ввели не верное значение для списка");
                        System.out.println("Введите размер списка");
                    } else {
                        System.out.println("ок размер зафиксирован");
                        stopBlock = false;
                    }
                } else {
                    System.out.println("вы ввели не верное значение для списка (out if)");
                    System.out.println("Введите размер списка от 1 до 10");
                    sc.next();
                }

            }

            System.out.println("начнем заполнять в следующем формате ...");
            System.out.println(typeFormat(classType));
            System.out.println(exampleOfType(classType));
            if(classType == 1){
                List<Car> listCar = getListCar(sc, listSize);
                System.out.println("по какому параметру сортировать список? 1.по мощности 2.названию 3.год выпуска");
                int sortForCar = 1;
                stopBlock = true;
                while (stopBlock) {
                    if(sc.hasNextInt()) {
                        sortForCar = sc.nextInt();
                        if(sortForCar < 1 || sortForCar > 3) {
                            System.out.println("вы ввели не верное значение");
                            System.out.println("(введите цифру 1-3): 1.по мощности 2.названию 3.год выпуска");
                        } else {
                            System.out.format("ок по %s", sortForCar == 1 ? "мощности" :
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
                listCar.sort(getComparatorForCar(sortForCar));
                System.out.println(listCar);
            } else if (classType == 2) {

            } else {

            }

        } else if (listForWork == 2) {
            System.out.println("Логика работы из файла");
        } else {
            System.out.println("Логика работы рандом");
        }

    }
    public static String typeFormat(int classType) {
        switch (classType) {
            case 0 : return "Что-то пошло не так))";
            case 1 : return "Мощность(л.с); Модель(); Год производства()";
            case 2 : return "Книга в разработке";
            case 3 : return "Корнеплод в разработке";
            default: return "";
        }
    }
    public static String exampleOfType(int classType) {
        switch (classType) {
            case 0 : return "Что-то пошло не так))";
            case 1 : return "135.0 Megan 2024 (Пример)";
            case 2 : return "Книга в разработке";
            case 3 : return "Корнеплод в разработке";
            default: return "";
        }
    }
    public static List<Car> getListCar(Scanner sc, int listSize) {
        List<Car> newList = new ArrayList<>();
        for (int i = 1; i <= listSize; i++) {
            double power = 0.0;
            String model = null;
            int yearOfProduction = 1;
            boolean stopBlockInput = true;
            while (stopBlockInput) {
                if (sc.hasNextDouble()) {
                    power = sc.nextDouble();
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
                model = sc.next();
                if (model != null) {
                    //Проверка в названии автомобиля только латинские буквы.
                    String[] modelChar = model.split("");
                    boolean b = true;
                    for(String s: modelChar){
                        if(!s.matches("[a-zA-Z]")){
                            b = false;
                            break;
                        }
                    }
                    if(b){
                        System.out.println("название автомобиля - " + model);
                        stopBlockInput = false;
                    } else {
                        System.out.println("название автомобиля не корректно");
                        System.out.println("только латинские буквы");
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
            Car car = new Car.Builder().power(power).model(model).yearOfProduction(yearOfProduction).build();
            System.out.println("занесли в список объект № " + i);
            newList.add(car);
        }
        return newList;
    }
    public static Comparator<Car> getComparatorForCar(int a) {
        Comparator<Car> comparator;
        switch (a) {
            case 1: comparator = new SortByDouble(); // исправить
            break;
            case 2: comparator = new SortByString();
            break;
            case 3: comparator = new DefaultSortByInt();
            break;
            default: comparator = new SortByDouble();
            break;
        }
        return comparator;
    }


}

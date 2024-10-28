package ProjectAston;

import java.util.*;
import ProjectAston.models.*;


public class Main {
    public static void main(String[] args) {

        //как работать со списком
        int listForWork = 0;

        //тип класса
        int classType = 0;

        //размер списка
        int listSize = 0;

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
                    System.out.format("способ выбран %s", listForWork == 1 ? "вручную" :
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
                    sc.next();
                }
            }

            System.out.println("начнем заполнять в следующем формате ...");
            System.out.println(typeFormat(classType));

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
                switch (sortForCar) {
                    case 1 : listCar.stream().sorted(Comparator.comparing(Car::getPower)).forEach(System.out::println);
                    break;
                    case 2 : listCar.stream().sorted(Comparator.comparing(Car::getModel)).forEach(System.out::println);
                    break;
                    case 3 : listCar.stream().sorted(Comparator.comparing(Car::getYear)).forEach(System.out::println);
                    break;
                }
            } else if (classType == 2) {
                List<Book> listBook = getListBook(sc, listSize);
                System.out.println("по какому параметру сортировать список? 1.автору 2.названию 3.количеству страниц");
                int sortForBook = 1;
                stopBlock = true;
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
            } else {
                List<RootCrop> listRootCrop = getListRootCrop(sc, listSize);
                System.out.println("по какому параметру сортировать список? 1.типу 2.весу 3.цвету");
                int sortForRootCrop = 1;
                stopBlock = true;
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

        } else if (listForWork == 2) {
            System.out.println("Логика работы из файла");
        } else {
            System.out.println("Логика работы рандом");
        }
    }
    public static String typeFormat(int classType) {
        switch (classType) {
            case 1 : return "Мощность(л.с); Модель; Год выпуска";
            case 2 : return "Автор; Название; Количество страниц";
            case 3 : return "Тип; Вес(кг.); Цвет";
            default: return "Что-то пошло не так";
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

package org.example.ui;

import org.example.models.Book;
import org.example.models.Car;
import org.example.models.RootCrop;
import org.example.repository.FileRepository;
import org.example.repository.FileRepositoryImpl;
import org.example.util.ScannerHolder;
import org.example.util.Validator;

import java.util.List;
import java.util.Optional;

public class UserMenu {
    public static final String DEFAULT_FILE_BOOKS = "books.out";
    public static final String DEFAULT_FILE_CARS = "cars.out";
    public static final String DEFAULT_FILE_ROOTCROP = "rootcrop.out";

    public static void userMenu() {
        int listForWork = 0;
        int classType = 0;
        System.out.println("Вас приветствует компания Aston");
        System.out.println("Будем работать со списками: автомобилей, книг, корнеплодов");
        System.out.println("выберите как работать со списком(введите цифру 1-3): 1.вручную  2.из файла  3.рандом");
        boolean stopBlock = true;
        while (stopBlock) {
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> choiceOpt = Validator.getValidInt(dataEntry);
            if (choiceOpt.isPresent() && choiceOpt.get() > 0 && choiceOpt.get() < 4) {
                int a = Integer.parseInt(dataEntry);
                listForWork = a;
                System.out.format("способ выбран %s", (a == 1 ? "вручную" : (a == 2 ? "из файла" : "рандом")));
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение для работы со списком");
                System.out.println("введите цифру 1-3: 1.вручную  2.из файла  3.рандом");
                stopBlock = true;
            }
        }

        System.out.println("выберите тип класса(введите цифру 1-3): 1.Автомобиль  2.Книга  3.Корнеплод");
        stopBlock = true;
        while (stopBlock) {
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> choiceOpt = Validator.getValidInt(dataEntry);
            if (choiceOpt.isPresent() && choiceOpt.get() > 0 && choiceOpt.get() < 4) {
                classType = choiceOpt.get();
                System.out.format("тип выбран %s", (classType == 1 ? "Автомобиль" : (classType == 2 ? "Книга" : "Корнеплод")));
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение для типа");
                System.out.println("выберите тип класса(введите цифру 1-3): 1.Автомобиль  2.Книга  3.Корнеплод");
                stopBlock = true;
            }
        }

        List objectList = null;

        if (listForWork == 1) {
            objectList = ManualInput.getList(classType);
        } else if (listForWork == 2) {
            if (classType == 1) {
                objectList = FileInput.getList(DEFAULT_FILE_CARS);
            } else if (classType == 2) {
                objectList = FileInput.getList(DEFAULT_FILE_BOOKS);
            } else {
                objectList = FileInput.getList(DEFAULT_FILE_ROOTCROP);
            }
        } else {
            objectList = RandomInput.getList(classType);
        }

        stopBlock = true;
        while (stopBlock) {
            System.out.println("Возможные дальнейшие действия со списком: 1.Отсортировать 2.Сохранить в файл 3.Выход");
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> choiceOpt = Validator.getValidInt(dataEntry);
            if (choiceOpt.isPresent() && choiceOpt.get() > 0 && choiceOpt.get() < 4) {
                switch (choiceOpt.get()) {
                    case 1:
                        customSorting(objectList, classType);
                        break;
                    case 2:
                        if (classType == 1) {
                            saveToFile((List<Car>) objectList, DEFAULT_FILE_CARS);
                        } else if (classType == 2) {
                            saveToFile((List<Book>) objectList, DEFAULT_FILE_BOOKS);
                        } else {
                            saveToFile((List<RootCrop>) objectList, DEFAULT_FILE_ROOTCROP);
                        }
                        break;
                    case 3:
                        stopBlock = false;
                        break;
                }
            } else {
                System.out.println("Некорректный ввод");
            }
        }
    }

    private static <T> void saveToFile(List<T> list, String fileName) {
        FileRepository<T> repository = new FileRepositoryImpl<>();
        repository.saveToFile(list, fileName);
    }

    private static void customSorting(List objectList, int classType) {
        if (classType == 1) {
            CustomSorting.customSortingOfCars((List<Car>) objectList);
        } else if (classType == 2) {
            CustomSorting.customSortingOfBook((List<Book>) objectList);
        } else {
            CustomSorting.customSortingOfRootCrop((List<RootCrop>) objectList);
        }
    }
}

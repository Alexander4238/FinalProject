package org.example.ui;

import org.example.repository.FileRepository;
import org.example.repository.FileRepositoryImpl;
import org.example.ui.input.FileInput;
import org.example.ui.input.InputStrategy;
import org.example.ui.input.ManualInput;
import org.example.ui.input.RandomInput;
import org.example.ui.manual_input.ManualListBook;
import org.example.ui.manual_input.ManualListCar;
import org.example.ui.manual_input.ManualListRootCrop;
import org.example.ui.manual_input.ManualListSupplierStrategy;
import org.example.util.ScannerHolder;
import org.example.util.Validator;
import org.example.util.default_file_saving.DefaultFileSavingBook;
import org.example.util.default_file_saving.DefaultFileSavingCar;
import org.example.util.default_file_saving.DefaultFileSavingRootCrop;
import org.example.util.default_file_saving.DefaultFileSavingStrategy;
import org.example.util.random.BookRandom;
import org.example.util.random.CarRandom;
import org.example.util.random.RandomGeneratorStrategy;
import org.example.util.random.RootCropRandom;
import org.example.util.sorting.CustomSortingBook;
import org.example.util.sorting.CustomSortingCar;
import org.example.util.sorting.CustomSortingRootCrop;
import org.example.util.sorting.CustomSortingStrategy;

import java.util.List;
import java.util.Optional;

public class UserMenu {
    private static InputStrategy inputStrategy;
    private static CustomSortingStrategy customSortingStrategy;
    private static DefaultFileSavingStrategy defaultFileSavingStrategy;
    private static ManualListSupplierStrategy manualListSupplierStrategy;
    private static RandomGeneratorStrategy randomGeneratorStrategy;

    public static void userMenu() {
        EntityType entityType = null;
        InputType inputType = null;
        System.out.println("Вас приветствует компания Aston");
        System.out.println("Будем работать со списками: автомобилей, книг, корнеплодов");
        System.out.println("выберите как работать со списком(введите цифру 1-3): 1.вручную  2.из файла  3.рандом");
        boolean stopBlock = true;
        while (stopBlock) {
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> choiceOpt = Validator.getValidInt(dataEntry);
            if (choiceOpt.isPresent() && choiceOpt.get() > 0 && choiceOpt.get() < 4) {
                int choice = choiceOpt.get();
                if (choice == 1) {
                    inputType = InputType.MANUAL;
                } else if (choice == 2) {
                    inputType = InputType.FILE;
                } else {
                    inputType = InputType.RANDOM;
                }
                System.out.format("способ выбран %s", (inputType.equals(InputType.MANUAL) ? "вручную" : (inputType.equals(InputType.FILE) ? "из файла" : "рандом")));
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
                int choice = choiceOpt.get();
                if (choice == 1) {
                    entityType = EntityType.CAR;
                } else if (choice == 2) {
                    entityType = EntityType.BOOK;
                } else {
                    entityType = EntityType.ROOTCROP;
                }
                System.out.format("тип выбран %s", (entityType.equals(EntityType.CAR) ? "Автомобиль" : (entityType.equals(EntityType.BOOK) ? "Книга" : "Корнеплод")));
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение для типа");
                System.out.println("выберите тип класса(введите цифру 1-3): 1.Автомобиль  2.Книга  3.Корнеплод");
                stopBlock = true;
            }
        }

        switch (entityType) {
            case CAR:
                customSortingStrategy = new CustomSortingCar();
                defaultFileSavingStrategy = new DefaultFileSavingCar();
                manualListSupplierStrategy = new ManualListCar();
                randomGeneratorStrategy = new CarRandom();
                break;
            case BOOK:
                customSortingStrategy = new CustomSortingBook();
                defaultFileSavingStrategy = new DefaultFileSavingBook();
                manualListSupplierStrategy = new ManualListBook();
                randomGeneratorStrategy = new BookRandom();
                break;
            case ROOTCROP:
                customSortingStrategy = new CustomSortingRootCrop();
                defaultFileSavingStrategy = new DefaultFileSavingRootCrop();
                manualListSupplierStrategy = new ManualListRootCrop();
                randomGeneratorStrategy = new RootCropRandom();
                break;
        }

        switch (inputType) {
            case MANUAL:
                inputStrategy = new ManualInput(manualListSupplierStrategy);
                break;
            case FILE:
                inputStrategy = new FileInput(defaultFileSavingStrategy);
                break;
            case RANDOM:
                inputStrategy = new RandomInput(randomGeneratorStrategy);
                break;
        }

        List objectList = inputStrategy.getList();

        stopBlock = true;
        while (stopBlock) {
            System.out.println("Возможные дальнейшие действия со списком: 1.Отсортировать 2.Сохранить в файл 3.Выход");
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> choiceOpt = Validator.getValidInt(dataEntry);
            if (choiceOpt.isPresent() && choiceOpt.get() > 0 && choiceOpt.get() < 4) {
                switch (choiceOpt.get()) {
                    case 1:
                        customSortingStrategy.customSorting(objectList);
                        break;
                    case 2:
                        FileRepository repository = new FileRepositoryImpl<>();
                        repository.saveToFile(objectList, defaultFileSavingStrategy.getFileName());
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

    private enum InputType {
        MANUAL,
        FILE,
        RANDOM
    }

    private enum EntityType {
        CAR,
        BOOK,
        ROOTCROP
    }
}

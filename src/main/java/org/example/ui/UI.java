package org.example.ui;

import org.example.repository.FileRepository;
import org.example.repository.FileRepositoryImpl;

import java.util.List;
import java.util.Scanner;

import static org.example.util.Validator.intValidate;

public class UI {
    private static boolean uiExit = false;

    public static void mainMenu() {

        String choice;
        Integer intChoice;

        System.out.println("Это приложение для сортировки");
        System.out.println("Выберите источник данных: 1 - из файла, 2 - случайный список, 3 - создать вручную");
        System.out.println("4 - завершить программу");

        while (!uiExit) {

            Scanner sc = new Scanner(System.in);
            choice = sc.nextLine();
            while (!intValidate(choice)) {
                System.out.println("Введите число!");
            }
            intChoice = Integer.parseInt(choice);

            if (intChoice == 4) {
                uiExit = true;
            } else if (intChoice < 1 || intChoice > 4) {
                System.out.println("Введите число от 1 до 4");
            }

            switch (intChoice) {
                case (1): {
                    processListFromFile();
                    break;
                }
                case (2): {
                    processRandomList();
                    break;
                }
                case (3): {
                    processManualList();
                    break;
                }
            }
        }
    }

    public static void processListFromFile() {
        String choice;
        Integer intChoice;
        List<?> list;

        System.out.println("Прочитать из файла - 1, Сохранить в файл - 2");

        Scanner sc = new Scanner(System.in);
        choice = sc.nextLine();

            intChoice = Integer.parseInt(choice);
            if (intChoice < 1 || intChoice > 2) {
                System.out.println("Введите число от 1 до 2");
            }
            switch (intChoice) {
                case (1): {
                    Scanner sc1 = new Scanner(System.in);
                    String filename = sc1.nextLine();
                    FileRepository<?> repository = new FileRepositoryImpl<>();
                    list = repository.readFromFile(filename);
                    printArray(list);
                    uiExit = true;
                    break;
                }

                case (2): {
                    processRandomList();
                    break;
                }
            }



    }

    static void printArray(List<?> list) {
        for (Object entity : list) {
            System.out.println(entity.toString());
        }
    }

    public static void processRandomList() {
        System.out.println("generate random list");
    }

    public static void processManualList() {
        System.out.println("create list manually");
    }


}

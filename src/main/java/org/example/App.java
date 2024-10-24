package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

\ublic class App {
    private static boolean uiExit = true;

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String choice;

        System.out.println("This is a sort application");
        System.out.println("Select data source to sort:");
        System.out.println("f - from file");
        System.out.println("r - random data");
        System.out.println("c - custom data");
        System.out.println("x - exit");

        while (uiExit) {
            try {
                choice = reader.readLine().toLowerCase();

                if (choice.equalsIgnoreCase("X")) {
                    uiExit = false;
                }

                switch (choice) {
                    case ("f"): {
                        processListFromFile();
                        break;
                    }
                    case ("r"): {
                        processRandomList();
                        break;
                    }
                    case ("c"): {
                        processManualList();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());;
            };
        }

    }

    public static void processListFromFile() {
        System.out.println("get list from file");
        System.out.println("pls, enter file address? x - to exit");
        System.out.println("file opened x - to exit, s - to sort");
    }

    public static void processRandomList() {
        System.out.println("generate random list");
    }

    public static void processManualList() {
        System.out.println("create list manually");
    }


}
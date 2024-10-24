package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static boolean uiExit = true;

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String choice;
        while (uiExit) {
            System.out.println("This is a sort application");
            System.out.println("Select data source to sort:");
            System.out.println("f - from file");
            System.out.println("r - random data");
            System.out.println("c - custom data");
            System.out.println("e - exit");
            try {
                choice = reader.readLine();
                if (choice.equalsIgnoreCase("Y")) {
                    uiExit = false;
                }
            } catch (IOException e) {
                System.out.println("pls enter correct letter");
            }
        }
    }
}
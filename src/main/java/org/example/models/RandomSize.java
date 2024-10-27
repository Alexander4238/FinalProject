package org.example.models;

import java.util.Scanner;

public class RandomSize {
    public int randomNumber() {
        Scanner in = new Scanner(System.in);
        int number;

        do {
            System.out.println("Введите размер массива от 1 до 5");
            while (!in.hasNextInt()) {
                System.out.println("Введите число от 1 до 5: ");
                in.next();
            }
            number = in.nextInt();
        } while (number < 1 || number > 5);
        in.close();
        return number;
    }
}

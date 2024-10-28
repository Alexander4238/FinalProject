package ProjectAston.userMenu;

import ProjectAston.models.Book;
import ProjectAston.models.Car;
import ProjectAston.models.RootCrop;
import ProjectAston.userInput.CustomSorting;
import ProjectAston.userInput.UserInput;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserMenu {
    public static void userMenu(){
        //как работать со списком
        int listForWork = 0;

        System.out.println("Вас приветствует компания Aston");
        System.out.println("Будет работать со списками: автомобилей, книг, корнеплодов");
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
            UserInput.manualWorkWithList(sc);
        } else if (listForWork == 2) {

            System.out.println("Логика работы из файла");

        } else {

            System.out.println("Логика работы рандом");

        }

    }
}

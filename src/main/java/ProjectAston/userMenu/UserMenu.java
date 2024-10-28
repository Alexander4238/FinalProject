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
//        //как работать со списком
        int listForWork = 0;

        System.out.println("Вас приветствует компания Aston");
        System.out.println("Будем работать со списками: автомобилей, книг, корнеплодов");
        System.out.println("выберите как работать со списком(введите цифру 1-3): 1.вручную  2.из файла  3.рандом");
        Scanner sc = new Scanner(System.in);
        boolean stopBlock = true;
        while (stopBlock) {
            String dataEntry = sc.nextLine();
            stopBlock = UserInput.onlyOneNumber(dataEntry);
            if(stopBlock){
                int a = Integer.parseInt(dataEntry);
                listForWork = a;
                System.out.format("способ выбран %s", (a == 1 ? "вручную" : (a == 2 ? "из файла" : "рандом")));
                System.out.println();
                stopBlock = false;
            }else {
                System.out.println("вы ввели не верное значение для работы со списком");
                System.out.println("введите цифру 1-3: 1.вручную  2.из файла  3.рандом");
                stopBlock = true;
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

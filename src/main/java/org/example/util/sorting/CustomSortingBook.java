package org.example.util.sorting;

import org.example.models.Book;
import org.example.util.ScannerHolder;
import org.example.util.Sort;
import org.example.util.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CustomSortingBook implements CustomSortingStrategy {
    @Override
    public void customSorting(List list) {
        List<Book> listBook = (List<Book>) list;
        int sortForBook = 1;
        boolean stopBlock = true;
        while (stopBlock) {
            System.out.println("по какому параметру сортировать список? 1.автору 2.названию 3.количеству страниц 4.четные по кол-ву страниц");
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> choiceOpt = Validator.getValidInt(dataEntry);
            if (choiceOpt.isPresent() && choiceOpt.get() > 0 && choiceOpt.get() < 5) {
                sortForBook = Integer.parseInt(dataEntry);
                System.out.format("по %s", sortForBook == 1 ? "автору" :
                        (sortForBook == 2 ? "названию" : (sortForBook == 3 ? "количеству страниц" : "четные по кол-ву страниц")));
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение");
                stopBlock = true;
            }
        }
        switch (sortForBook) {
            case 1:
                Sort.mergeSort(listBook, Comparator.comparing(Book::getAuthor));
                break;
            case 2:
                Sort.mergeSort(listBook, Comparator.comparing(Book::getTitle));
                break;
            case 3:
                Sort.mergeSort(listBook, Comparator.comparing(Book::getPagesQuantity));
                break;
            case 4:
                Sort.sortEvenNatural(listBook, Comparator.comparing(Book::getPagesQuantity));
                break;
        }
        listBook.forEach(System.out::println);
    }
}

package org.example.ui.manual_input;

import org.example.models.Book;
import org.example.util.ScannerHolder;

import java.util.ArrayList;
import java.util.List;

public class ManualListBook implements ManualListSupplierStrategy {
    @Override
    public List getList(int size) {
        System.out.println("Автор; Название; Количество страниц");
        List<Book> newList = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            String author = null;
            String title = null;
            int pagesQuantity = 0;

            System.out.println("введите автора");
            boolean stopBlockInput = true;
            while (stopBlockInput) {
                author = ScannerHolder.get().nextLine();
                if (author != null) {
                    //Проверка в названии только латинские буквы.
                    String[] authorChar = author.split("");
                    boolean b = true;
                    for (String s : authorChar) {
                        if (!s.matches("[a-zA-Z ]")) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        if (author.length() < 50) {
                            System.out.println("автор - " + author);
                            stopBlockInput = false;
                        } else {
                            System.out.println("автора ввели не корректно");
                            System.out.println("только латинские буквы не более 50 символов");
                        }
                    } else {
                        System.out.println("автора ввели не корректно");
                        System.out.println("только латинские буквы не более 50 символов");
                    }
                }
            }

            System.out.println("введите название книги");
            stopBlockInput = true;
            while (stopBlockInput) {
                title = ScannerHolder.get().nextLine();
                if (title != null) {
                    //Проверка в названии только латинские буквы.
                    String[] titleChar = title.split("");
                    boolean b = true;
                    for (String s : titleChar) {
                        if (!s.matches("[a-zA-Z0-9 ]")) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        if (title.length() < 50) {
                            System.out.println("название книги - " + title);
                            stopBlockInput = false;
                        } else {
                            System.out.println("название книги ввели не корректно");
                            System.out.println("только латинские буквы и цифры не более 50 символов");
                        }
                    } else {
                        System.out.println("название книги ввели не корректно");
                        System.out.println("только латинские буквы и цифры не более 50 символов");
                    }
                }
            }

            System.out.println("введите количество страниц");
            stopBlockInput = true;
            while (stopBlockInput) {
                String dataEntry = ScannerHolder.get().nextLine();
                stopBlockInput = pagesQuantityForBooks(dataEntry);
                if (stopBlockInput) {
                    int a = Integer.parseInt(dataEntry);
                    pagesQuantity = a;
                    System.out.println("количество страниц - " + pagesQuantity);
                    System.out.println();
                    stopBlockInput = false;
                } else {
                    System.out.println("вы ввели не верное значение для количество страниц");
                    System.out.println("введите число от 1 до 5000");
                    stopBlockInput = true;
                }
            }

            Book book = new Book.BookBuilder().author(author).title(title).pagesQuantity(pagesQuantity).build();
            System.out.println("занесли в список объект № " + i);
            newList.add(book);

        }
        return newList;
    }

    public boolean pagesQuantityForBooks(String strLine) {
        boolean b = true;
        String[] dataEntryArray = strLine.split("");
        for (String s : dataEntryArray) {
            if (s.matches("[0-9]")) {
            } else {
                b = false;
                break;
            }
        }
        if (b) {
            int a = Integer.parseInt(strLine);
            if (a > 0 && a < 5001) {
                return b;
            } else {
                b = false;
                return b;
            }
        } else {
            return b;
        }
    }
}

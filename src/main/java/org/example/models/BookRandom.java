package org.example.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class BookRandom {
    public static void main (String[] args) {

        RandomSize randomSize = new RandomSize();
        int number = randomSize.randomNumber();

        List<Book> bookList = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            Book book = new Book.BookBuilder()
                    .author(getRandomAuthor())
                    .title(getRandomTitle())
                    .pagesQuantity(getRandomPagesQuantity()).
                    build();
            bookList.add(book);
        }

//        for(Book book : bookList) {
//            System.out.println(book.getAuthor());
//            System.out.println(book.getTitle());
//            System.out.println(book.getPagesQuantity());
//        }
    }

    private static String getRandomAuthor() {
        String[] authors = {"Блок", "Маяковский", "Есенин", "Пастернак", "Ахматова", "Волошин"};
        Random random = new Random();
        return authors[random.nextInt(authors.length)];
    }

    private static String getRandomTitle() {
        String[] titles = {"Петербург", "Белая Гвардия", "Стихотворения", "Двенадцать", "Мелкий бес", "Голос"};
        Random random = new Random();
        return titles[random.nextInt(titles.length)];
    }


    private static int getRandomPagesQuantity() {
        Random random = new Random();
        return random.nextInt(150) + 50;
    }
}



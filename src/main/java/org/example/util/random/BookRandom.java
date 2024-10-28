package org.example.util.random;

import org.example.models.Book;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.util.random.RandomUtils.getRandomIntInRange;
import static org.example.util.random.RandomUtils.getRandomStringFromArray;

public abstract class BookRandom {

    private static final int PAGE_MIN = 100;
    private static final int PAGE_MAX = 1000;
    private static final String[] authors = {"Блок", "Маяковский", "Есенин", "Пастернак", "Ахматова", "Волошин"};
    private static final String[] titles = {"Петербург", "Белая Гвардия", "Стихотворения", "Двенадцать", "Мелкий бес", "Голос"};

    public static List<Book> getRandomList(int listSize) {
        return Stream.generate(() ->
                        new Book.BookBuilder()
                                .author(getRandomStringFromArray(authors))
                                .title(getRandomStringFromArray(titles))
                                .pagesQuantity(getRandomIntInRange(PAGE_MIN, PAGE_MAX))
                                .build())
                .limit(listSize)
                .collect(Collectors.toList());
    }
}



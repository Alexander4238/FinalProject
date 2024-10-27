package org.example.models;

import java.io.Serializable;

public class Book implements Serializable {

    private final String author;
    private final String title;
    private final int pagesQuantity;

    private Book(BookBuilder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pagesQuantity = builder.pagesQuantity;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPagesQuantity() {
        return pagesQuantity;
    }

    @Override
    public String toString() {
        return String.format("Книга: Название: %s, Автор: %s, Количество страниц: %d", getTitle(), getAuthor(), getPagesQuantity());
    }

    public static class BookBuilder {
        private String author;
        private String title;
        private Integer pagesQuantity;

        public BookBuilder() {}

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder pagesQuantity(Integer pagesQuantity) {
            this.pagesQuantity = pagesQuantity;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

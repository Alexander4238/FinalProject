package ProjectAston;

public class Book {
    private String author;
    private String bookTitle;
    private Integer numberOfPages;

    public String getAuthor() {
        return author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }

    public static class Builder {
        private Book book;
        public Builder(){
            book = new Book();
        }
        public Builder author(String author) {
            book.author = author;
            return this;
        }
        public Builder bookTitle(String bookTitle) {
            book.bookTitle = bookTitle;
            return this;
        }
        public Builder numberOfPages(Integer numberOfPages) {
            book.numberOfPages = numberOfPages;
            return this;
        }
        public Book build() {
            return book;
        }
    }
}

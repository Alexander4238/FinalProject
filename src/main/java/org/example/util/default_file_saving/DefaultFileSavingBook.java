package org.example.util.default_file_saving;

public class DefaultFileSavingBook implements DefaultFileSavingStrategy {
    @Override
    public String getFileName() {
        return "books.out";
    }
}

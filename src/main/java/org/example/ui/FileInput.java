package org.example.ui;

import org.example.repository.FileRepository;
import org.example.repository.FileRepositoryImpl;

import java.util.List;

public abstract class FileInput {
    public static <T> List<T> getList(String fileName) {
        FileRepository<T> repository = new FileRepositoryImpl<>();
        List<T> result = repository.readFromFile(fileName);
        result.forEach(System.out::println);
        return result;
    }
}

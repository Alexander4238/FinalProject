package org.example.repository;

import java.util.List;

public interface FileRepository<T> {
    void saveToFile(List<T> list, String fileName);
    List<T> readFromFile(String fileName);
}

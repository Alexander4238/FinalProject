package org.example.repository;

import java.util.List;

public interface InMemoryRepository<T> {
    void saveAll(List<T> list);
    List<T> readAll();
}

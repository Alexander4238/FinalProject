package org.example.repository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepositoryImpl<T> implements InMemoryRepository<T> {
    private List<T> storage;

    {
        storage = new ArrayList<>();
    }

    @Override
    public void saveAll(List<T> list) {
        storage = list;
    }

    @Override
    public List<T> readAll() {
        return storage;
    }
}

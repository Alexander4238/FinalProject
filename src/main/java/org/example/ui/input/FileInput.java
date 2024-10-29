package org.example.ui.input;

import org.example.repository.FileRepository;
import org.example.repository.FileRepositoryImpl;
import org.example.util.default_file_saving.DefaultFileSavingStrategy;

import java.util.List;

public class FileInput implements InputStrategy {
    private final DefaultFileSavingStrategy defaultFileSavingStrategy;

    public FileInput(DefaultFileSavingStrategy defaultFileSavingStrategy) {
        this.defaultFileSavingStrategy = defaultFileSavingStrategy;
    }

    public List getList() {
        FileRepository<Object> repository = new FileRepositoryImpl<>();
        List result = repository.readFromFile(defaultFileSavingStrategy.getFileName());
        result.forEach(System.out::println);
        return result;
    }
}

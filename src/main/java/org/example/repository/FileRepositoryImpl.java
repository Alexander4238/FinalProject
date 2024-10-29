package org.example.repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileRepositoryImpl<T> implements FileRepository<T> {

    @Override
    public void saveToFile(List<T> list, String fileName) {
        List<T> existList = null;
        if (Files.exists(Path.of(fileName))) {
            existList = new ArrayList<T>(readFromFile(fileName));
            existList.addAll(list);
        } else {
            existList = list;
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName, false))) {
            objectOutputStream.writeObject(existList);
        } catch (IOException e) {
            System.out.println("Fail to save file!");
        }
    }

    @Override
    public List<T> readFromFile(String fileName) {
        List<T> result = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            result = (List<T>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("File read error!");
        } catch (ClassNotFoundException e) {
            System.out.println(String.format("File doesn't contain necessary type!"));
        }
        return result;
    }
}

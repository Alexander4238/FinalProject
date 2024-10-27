package org.example.repository;

import org.example.models.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRepositoryImpl<T> implements FileRepository<T>{

    @Override
    public void saveToFile(List<T> list, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName, true))) {
            for (T element : list) {
                objectOutputStream.writeObject(element);
            }

        } catch (IOException e) {
            System.out.println("Fail to save file!");
        }
    }

    @Override
    public List<T> readFromFile(String fileName) {
        List<T> result = new ArrayList<>();

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            Object obj = null;
            while ((obj = objectInputStream.readObject()) != null) {
                result.add((T) obj);
            }
        } catch (IOException e) {
            System.out.println("File read error!");
        } catch (ClassNotFoundException e) {
            System.out.println(String.format("File doesn't contain necessary type!"));
        }
        return result;
    }
}

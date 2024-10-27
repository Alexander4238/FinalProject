package org.example.repository;

import java.io.*;
import java.util.List;

public class FileRepositoryImpl<T> implements FileRepository<T>{

    @Override
    public void saveToFile(List<T> list, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName, true))) {
                objectOutputStream.writeObject(list);
        } catch (IOException e) {
            System.out.println("Fail to save file!");
        }
    }

    @Override
    public List<T> readFromFile(String fileName) {
        List<T> result = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
                result = (List<T>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("File read error!");
        } catch (ClassNotFoundException e) {
            System.out.println(String.format("File doesn't contain necessary type!"));
        }
        return result;
    }
}

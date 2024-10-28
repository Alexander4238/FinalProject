package org.example.ui;

import org.example.models.RootCrop;
import org.example.util.ScannerHolder;
import org.example.util.Validator;
import org.example.util.random.BookRandom;
import org.example.util.random.CarRandom;
import org.example.util.random.RootCropRandom;

import java.util.List;
import java.util.Optional;

public class RandomInput {
    public static List getList(int classType) {
        int listSize = 0;
        System.out.println("введите размер списка");
        boolean stopBlock = true;
        while (stopBlock) {
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> sizeOpt = Validator.getValidInt(dataEntry);
            if (sizeOpt.isPresent() && sizeOpt.get() > 0 && sizeOpt.get() < 11) {
                listSize = Integer.parseInt(dataEntry);
                System.out.println("размер списка - " + listSize);
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение для списка");
                System.out.println("введите размер списка от 1 до 10 (размер для теста)");
                stopBlock = true;
            }
        }

        List list = null;
        if (classType == 1) {
            list = CarRandom.getRandomList(listSize);
        } else if (classType == 2) {
            list = BookRandom.getRandomList(listSize);
        } else {
            list = RootCropRandom.getRandomList(listSize);
        }
        list.forEach(System.out::println);
        return list;
    }
}

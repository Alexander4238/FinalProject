package org.example.ui.input;

import org.example.util.ScannerHolder;
import org.example.util.Validator;
import org.example.util.random.RandomGeneratorStrategy;

import java.util.List;
import java.util.Optional;

public class RandomInput implements InputStrategy {
    private final RandomGeneratorStrategy randomGenerator;

    public RandomInput(RandomGeneratorStrategy randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public List getList() {
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

        List list = randomGenerator.getRandomList(listSize);
        list.forEach(System.out::println);
        return list;
    }
}

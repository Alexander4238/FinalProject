package org.example.util.random;

import org.example.models.RootCrop;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.util.random.RandomUtils.getRandomIntInRange;
import static org.example.util.random.RandomUtils.getRandomStringFromArray;

public abstract class RootCropRandom {

    private static final int WEIGHT_MIN = 100;
    private static final int WEIGHT_MAX = 5000;
    private static final String[] types = {"Морковь", "Репа", "Свёкла", "Редис", "Картошка", "Хрен"};
    private static final String[] colors = {"Красный", "Белый", "Оранжевый", "Коричневый", "Серый", "Желтый"};

    public static List<RootCrop> getRandomList(int listSize) {
        return Stream.generate(() ->
                        new RootCrop.RootCropBuilder()
                                .setType(getRandomStringFromArray(types))
                                .setWeight(getRandomIntInRange(WEIGHT_MIN, WEIGHT_MAX))
                                .setColor(getRandomStringFromArray(colors))
                                .build())
                .limit(listSize)
                .collect(Collectors.toList());
    }
}
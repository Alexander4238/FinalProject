package org.example.util.random;

import org.example.models.RootCrop;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.util.random.RandomUtils.getRandomDoubleInRange;
import static org.example.util.random.RandomUtils.getRandomStringFromArray;

public class RootCropRandom implements RandomGeneratorStrategy {

    private static final double WEIGHT_MIN = 100.0;
    private static final double WEIGHT_MAX = 5000.0;
    private static final String[] types = {"Морковь", "Репа", "Свёкла", "Редис", "Картошка", "Хрен"};
    private static final String[] colors = {"Красный", "Белый", "Оранжевый", "Коричневый", "Серый", "Желтый"};

    public List<RootCrop> getRandomList(int listSize) {
        return Stream.generate(() ->
                        new RootCrop.RootCropBuilder()
                                .setType(getRandomStringFromArray(types))
                                .setWeight(getRandomDoubleInRange(WEIGHT_MIN, WEIGHT_MAX))
                                .setColor(getRandomStringFromArray(colors))
                                .build())
                .limit(listSize)
                .collect(Collectors.toList());
    }
}
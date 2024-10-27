package org.example.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class RootCropRandom {
    public static void main (String[] args) {

        RandomSize randomSize = new RandomSize();
        int number = randomSize.randomNumber();

        List<RootCrop> rootCropList = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            RootCrop rootCrop = new RootCrop.RootCropBuilder()
                    .setType(getRandomType())
                    .setWeight(getRandomWeight())
                    .setColor(getRandomColor()).
                    build();
            rootCropList.add(rootCrop);
        }

//        for(RootCrop rootCrop : rootCropList) {
//            System.out.println(rootCrop.getType());
//            System.out.println(rootCrop.getWeight());
//            System.out.println(rootCrop.getColor());
//        }
    }

    private static String getRandomType() {
        String[] types = {"Морковь", "Репа", "Свёкла", "Редис", "Картошка", "Хрен"};
        Random random = new Random();
        return types[random.nextInt(types.length)];
    }

    private static double getRandomWeight() {
        Random random = new Random();
        return Math.round ((3.5 * random.nextDouble() + 0.5) * 100.0) / 100.0;
    }

    private static String getRandomColor() {
        String[] colors = {"Морковь", "Репа", "Свёкла", "Редис", "Картошка", "Хрен"};
        Random random = new Random();
        return colors[random.nextInt(colors.length)];
    }

}
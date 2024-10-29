package org.example.util.sorting;

import org.example.models.RootCrop;
import org.example.util.ScannerHolder;
import org.example.util.Sort;
import org.example.util.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CustomSortingRootCrop implements CustomSortingStrategy {
    @Override
    public void customSorting(List list) {
        List<RootCrop> listRootCrop = (List<RootCrop>) list;
        int sortForRootCrop = 1;
        boolean stopBlock = true;
        while (stopBlock) {
            System.out.println("по какому параметру сортировать список? 1.типу 2.весу 3.цвету 4.четные по весу");
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> choiceOpt = Validator.getValidInt(dataEntry);
            if (choiceOpt.isPresent() && choiceOpt.get() > 0 && choiceOpt.get() < 5) {
                sortForRootCrop = Integer.parseInt(dataEntry);
                System.out.format("по %s", sortForRootCrop == 1 ? "типу" :
                        (sortForRootCrop == 2 ? "весу" : (sortForRootCrop == 3 ? "цвету" : "четные по весу")));
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение");
                stopBlock = true;
            }
        }
        switch (sortForRootCrop) {
            case 1:
                Sort.mergeSort(listRootCrop, Comparator.comparing(RootCrop::getType));
                break;
            case 2:
                Sort.mergeSort(listRootCrop, Comparator.comparing(RootCrop::getWeight));
                break;
            case 3:
                Sort.mergeSort(listRootCrop, Comparator.comparing(RootCrop::getColor));
                break;
            case 4:
                Sort.sortEvenNatural(listRootCrop, Comparator.comparing(RootCrop::getWeight));
                break;
        }
        listRootCrop.forEach(System.out::println);
    }
}

package org.example.ui.input;

import org.example.ui.manual_input.ManualListSupplierStrategy;
import org.example.util.ScannerHolder;
import org.example.util.Validator;

import java.util.List;
import java.util.Optional;

public class ManualInput implements InputStrategy {
    private final ManualListSupplierStrategy manualListSupplierStrategy;

    public ManualInput(ManualListSupplierStrategy manualListSupplierStrategy) {
        this.manualListSupplierStrategy = manualListSupplierStrategy;
    }

    public List getList() {
        int size = 0;
        System.out.println("введите размер списка");
        boolean stopBlock = true;
        while (stopBlock) {
            String dataEntry = ScannerHolder.get().nextLine();
            Optional<Integer> sizeOpt = Validator.getValidInt(dataEntry);
            if (sizeOpt.isPresent() && sizeOpt.get() > 0 && sizeOpt.get() < 11) {
                size = Integer.parseInt(dataEntry);
                System.out.println("размер списка - " + size);
                System.out.println();
                stopBlock = false;
            } else {
                System.out.println("вы ввели не верное значение для списка");
                System.out.println("введите размер списка от 1 до 10 (размер для теста)");
                stopBlock = true;
            }
        }

        System.out.println("начнем заполнять в следующем формате ...");

        return manualListSupplierStrategy.getList(size);
    }
}

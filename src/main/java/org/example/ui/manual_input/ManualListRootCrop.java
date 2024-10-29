package org.example.ui.manual_input;

import org.example.models.RootCrop;
import org.example.util.ScannerHolder;

import java.util.ArrayList;
import java.util.List;

public class ManualListRootCrop implements ManualListSupplierStrategy {
    @Override
    public List getList(int size) {
        System.out.println("Тип; Вес(кг.); Цвет");
        List<RootCrop> newList = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            String type = null;
            double weight = 0.0;
            String color = null;

            System.out.println("введите тип корнеплода");
            boolean stopBlockInput = true;
            while (stopBlockInput) {
                type = ScannerHolder.get().nextLine();
                if (type != null) {
                    //Проверка в названии автомобиля только латинские буквы и цифры.
                    String[] typeChar = type.split("");
                    boolean b = true;
                    for (String s : typeChar) {
                        if (!s.matches("[a-zA-Z0-9 ]")) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        if (type.length() < 50) {
                            System.out.println("тип корнеплода - " + type);
                            stopBlockInput = false;
                        } else {
                            System.out.println("название типа корнеплода не корректно");
                            System.out.println("только латинские буквы и цифры не более 50 символов");
                        }
                    } else {
                        System.out.println("название типа корнеплода не корректно");
                        System.out.println("только латинские буквы и цифры не более 50 символов");
                    }
                }
            }

            System.out.println("введите вес корнеплода в кг.");
            stopBlockInput = true;
            while (stopBlockInput) {
                String dataEntry = ScannerHolder.get().nextLine();
                stopBlockInput = weightRootCrop(dataEntry);
                if (stopBlockInput) {
                    double a = Double.parseDouble(dataEntry);
                    weight = a;
                    System.out.println("вес корнеплода - " + weight + " кг.");
                    System.out.println();
                    stopBlockInput = false;
                } else {
                    System.out.println("вы ввели не верный вес корнеплода");
                    System.out.println("введите число от 1.0 до 1000.0");
                    stopBlockInput = true;
                }
            }

            System.out.println("введите цвет");
            stopBlockInput = true;
            while (stopBlockInput) {
                color = ScannerHolder.get().nextLine();
                if (color != null) {
                    //Проверка в названии только латинские буквы и цифры.
                    String[] colorChar = color.split("");
                    boolean b = true;
                    for (String s : colorChar) {
                        if (!s.matches("[a-zA-Z0-9 ]")) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        if (color.length() < 50) {
                            System.out.println("цвет корнеплода - " + color);
                            stopBlockInput = false;
                        } else {
                            System.out.println("цвет корнеплода не корректен");
                            System.out.println("только латинские буквы и цифры не более 50 символов");
                        }
                    } else {
                        System.out.println("цвет корнеплода не корректен");
                        System.out.println("только латинские буквы и цифры не более 50 символов");
                    }
                }
            }

            RootCrop rootCrop = new RootCrop.RootCropBuilder().setType(type).setWeight(weight).setColor(color).build();
            System.out.println("занесли в список объект № " + i);
            newList.add(rootCrop);
        }
        return newList;
    }

    public boolean weightRootCrop(String strLine) {
        boolean b = true;
        String[] dataEntryArray = strLine.split("");
        for (String s : dataEntryArray) {
            if (s.matches("[0-9.]")) {
            } else {
                b = false;
                break;
            }
        }
        if (b) {
            double a = Double.parseDouble(strLine);
            if (a > 0 && a < 1001) {
                return b;
            } else {
                b = false;
                return b;
            }
        } else {
            return b;
        }
    }
}

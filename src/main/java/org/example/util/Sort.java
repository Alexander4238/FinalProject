package org.example.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Sort {
    public static <T extends Comparable> void mergeSort(List<T> list) {
        mergeSort(list, T::compareTo);
    }

    public static <T> void sortEvenNatural(List<T> list, Comparator<T> comparator) {
        List<T> sortEvenList = new ArrayList<>();
        Queue<T> queue = new LinkedList<>();

        for (int i = 1; i < list.size(); i+=2) {
            T obj = list.get(i);
            sortEvenList.add(obj);
        }
        sortEvenList.sort(comparator);
        queue.addAll(sortEvenList);

        for (int i = 1; i < list.size(); i+=2) {
            list.set(i, queue.poll());
        }
    }

    public static <T> void mergeSort(List<T> list, Comparator<T> comparator) {
        if (list.size() <= 1) {
            return;
        }

        int mid = list.size() / 2;
        List<T> left = new ArrayList<>(list.subList(0, mid));
        List<T> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(list, left, right, comparator);
    }

    private static <T> void merge(List<T> list, List<T> left, List<T> right, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
}

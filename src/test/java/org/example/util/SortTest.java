package org.example.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SortTest {

    static Stream<Arguments> intCaseProvider() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4))),
                Arguments.of(new ArrayList<>(Arrays.asList(100, -51, 21, 0))),
                Arguments.of(new ArrayList<>(Arrays.asList(7, 7, 7, 7))),
                Arguments.of(new ArrayList<>(Arrays.asList(0, 0))),
                Arguments.of(new ArrayList<>(Arrays.asList(0))),
                Arguments.of(new ArrayList<>(Arrays.asList()))
        );
    }

    @ParameterizedTest
    @MethodSource("intCaseProvider")
    void mergeSortIntDefaultComparing(List<Integer> input) {
        List<Integer> expectedSortedList = new ArrayList<>(input);
        List<Integer> actualSortedList = new ArrayList<>(input);
        Collections.sort(expectedSortedList);
        Sort.mergeSort(actualSortedList);
        assertEquals(expectedSortedList, actualSortedList);
    }

    @ParameterizedTest
    @MethodSource("intCaseProvider")
    void mergeSortIntReverseOrderComparing(List<Integer> input) {
        List<Integer> expectedSortedList = new ArrayList<>(input);
        List<Integer> actualSortedList = new ArrayList<>(input);
        Collections.sort(expectedSortedList, Comparator.reverseOrder());
        Sort.mergeSort(actualSortedList, Comparator.reverseOrder());
        assertEquals(expectedSortedList, actualSortedList);
    }

    static Stream<Arguments> stringCaseProvider() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList("apple", "Banana", "cherry", "date", "Elderberry"))),
                Arguments.of(new ArrayList<>(Arrays.asList("apple1", "apple10", "apple2", "banana", "banana10"))),
                Arguments.of(new ArrayList<>(Arrays.asList("", " ", "apple", "banana", "  cherry  "))),
                Arguments.of(new ArrayList<>(Arrays.asList("apple", "banana", "apple", "cherry", "banana"))),
                Arguments.of(new ArrayList<>(Arrays.asList("apple!", "banana@", "#cherry", "$date", "%elderberry"))),
                Arguments.of(new ArrayList<>(Arrays.asList("a", "ab", "abc", "abcd", "abcde"))),
                Arguments.of(new ArrayList<>(Arrays.asList("zebra", "lion", "tiger", "elephant", "giraffe"))),
                Arguments.of(new ArrayList<>(Arrays.asList(" banana", "apple", " cherry", "date ", "elderberry"))),
                Arguments.of(new ArrayList<>(Arrays.asList("cat", "dog", "Aardvark", "elephant!", "1zebra"))),
                Arguments.of(new ArrayList<>(Arrays.asList("", "", "", "", ""))),
                Arguments.of(new ArrayList<>(Arrays.asList(""))),
                Arguments.of(new ArrayList<>(Arrays.asList()))
        );
    }

    @ParameterizedTest
    @MethodSource("stringCaseProvider")
    void mergeSortStringDefaultComparing(List<String> input) {
        List<String> expectedSortedList = new ArrayList<>(input);
        List<String> actualSortedList = new ArrayList<>(input);
        Collections.sort(expectedSortedList);
        Sort.mergeSort(actualSortedList);
        assertEquals(expectedSortedList, actualSortedList);
    }

    @ParameterizedTest
    @MethodSource("stringCaseProvider")
    void mergeSortStringReverseOrderComparing(List<String> input) {
        List<String> expectedSortedList = new ArrayList<>(input);
        List<String> actualSortedList = new ArrayList<>(input);
        Collections.sort(expectedSortedList, Comparator.reverseOrder());
        Sort.mergeSort(actualSortedList, Comparator.reverseOrder());
        assertEquals(expectedSortedList, actualSortedList);
    }
}
package org.example.util;

import java.util.Scanner;

public abstract class ScannerHolder {
    private static Scanner sc = new Scanner(System.in);

    public static Scanner get() {
        return sc;
    }
}

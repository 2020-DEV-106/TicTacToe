package com.tdd.kata.io;

import java.util.Scanner;

public class InputScanner {

    public static final Scanner SCANNER = new Scanner(System.in);

    public String nextLine() {
        return SCANNER.nextLine();
    }
}
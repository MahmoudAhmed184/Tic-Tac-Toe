package com.mahmoud_ahmed.ui;

import java.util.Scanner;

public class ConsoleInput {
    private static final Scanner scanner = new Scanner(System.in);

    public ConsoleInput() {}

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public char getCharInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? ' ' : input.charAt(0);
    }

    public int getIntegerInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Invalid input! Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number");
            }
        }
    }
}
package com.mahmoud_ahmed.ui;

public class ConsoleDisplay {
    
    public ConsoleDisplay() {}

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }
}
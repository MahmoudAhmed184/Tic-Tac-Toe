package com.tictactoe.game;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GameUtils {
    private static final Pattern NAME_PATTERN = Pattern.compile("[a-z]+( [a-z]+)*", Pattern.CASE_INSENSITIVE);
    private static final Scanner SCANNER = new Scanner(System.in);

    private GameUtils() {
        // Prevent instantiation
    }

    public static Player getPlayer() {
        String name = getPlayerName();
        char symbol = getPlayerSymbol();
        return new Player(name, symbol);
    }

    private static String getPlayerName() {
        String name;
        do {
            System.out.print("Enter player name: ");
            name = SCANNER.nextLine();
        } while (!NAME_PATTERN.matcher(name).matches());
        return name;
    }

    private static char getPlayerSymbol() {
        char symbol;
        do {
            System.out.print("Enter player's symbol: ");
            symbol = SCANNER.next().charAt(0);
        } while (symbol == '_' || symbol == ' ');
        SCANNER.nextLine();
        return symbol;
    }

    public static int getPlayerMove(String message) {
        System.out.print(message);
        while (!SCANNER.hasNextInt()) {
            System.out.print("That's not a valid input! Please enter a number: ");
            SCANNER.nextLine();
        }
        return SCANNER.nextInt();
    }
}

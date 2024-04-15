package com.tictactoe;

import com.tictactoe.game.GameManager;

public class Main {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager(3, 2);
        gameManager.startGame();
    }
}

package com.tictactoe.game;

import java.util.stream.IntStream;

public class GameManager {
    private final Board board;
    private final Player[] players;
    private int playerTurn;
    private final String validMovesMessage;

    public GameManager(int boardSize, int numberOfPlayers) {
        this.board = new Board(boardSize);
        this.players = new Player[numberOfPlayers];
        this.playerTurn = 0;
        this.validMovesMessage = "Enter your move from 1 to " + boardSize * boardSize + ": ";
    }

    public void startGame() {
        initializePlayers();
        while (true) {
            board.displayBoard();
            System.out.println("Player Turn: " + players[playerTurn]);
            int position = GameUtils.getPlayerMove(validMovesMessage);
            while (!players[playerTurn].makeMove(board, position)) {
                position = GameUtils.getPlayerMove(validMovesMessage);
            }
            if (isGameOver()) {
                break;
            }
            switchPlayerTurn();
        }
    }

    private void initializePlayers() {
        IntStream.range(0, players.length)
                .forEach(i -> players[i] = GameUtils.getPlayer());
    }

    private void switchPlayerTurn() {
        this.playerTurn = (playerTurn + 1) % players.length;
    }

    private boolean isGameOver() {
        if (board.isWinningMove(players[playerTurn].getSymbol())) {
            board.displayBoard();
            System.out.println("Player " + players[playerTurn] + " wins!");
            return true;
        }
        if (!board.isMoveLeft()) {
            board.displayBoard();
            System.out.println("Game is a draw!");
            return true;
        }
        return false;
    }
}

package com.tictactoe.game;

import java.util.stream.IntStream;

public class GameManager {
    private final Board board;
    private final Player[] players;
    private final String MOVE_MESSAGE;
    private int playerTurn;

    public GameManager(int boardSize, int numberOfPlayers) {
        this.board = new Board(boardSize);
        this.players = new Player[numberOfPlayers];
        this.playerTurn = 0;
        this.MOVE_MESSAGE = "Enter your move from 1 to " + boardSize * boardSize + ": ";
    }

    public void startGame() {
        initializePlayers();
        while (board.isMoveLeft()) {
            board.displayBoard();
            System.out.println("Player Turn: " + players[playerTurn]);
            int position = GameUtils.getPlayerMove(MOVE_MESSAGE);
            while (!players[playerTurn].makeMove(board, position)) {
                position = GameUtils.getPlayerMove(MOVE_MESSAGE);
            }
            evaluateGame();
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

    public void evaluateGame() {

    }
}

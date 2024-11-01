package com.mahmoud_ahmed.game;

import java.util.stream.IntStream;
import com.mahmoud_ahmed.model.*;
import com.mahmoud_ahmed.ui.*;

public class Game {
    private final Console console;
    private final Board board;
    private final PlayerTurnManager turnManager;
    private final GameEvaluator evaluator;
    private GameState currentState;

    public Game(int boardSize, int numberOfPlayers) {
        this.console = new Console();
        this.board = new Board(boardSize);
        this.turnManager = new PlayerTurnManager(numberOfPlayers);
        initializePlayers(numberOfPlayers);
        this.evaluator = new GameEvaluator();
        this.currentState = GameState.IN_PROGESS;
    }

    private void initializePlayers(int numberOfPlayers) {
        IntStream.range(0, numberOfPlayers)
                .forEach(playerNumber -> turnManager.addPlayer(console.createPlayer(playerNumber)));
    }

    public void startGame() {
        while (currentState == GameState.IN_PROGESS) {
            processTurn();
            updateGameState();
        }
        handleGameOver();
    }

    private void processTurn() {
        console.displayBoard(board);
        Player currentPlayer = turnManager.getCurrentPlayer();
        console.displayPlayerTurn(currentPlayer);
        int position = GameHelper.getValidPosition(console, board);
        board.applyMove(position, currentPlayer.getSymbol());
    }

    private void updateGameState() {
        currentState = evaluator.evaluateGame(board, turnManager.getCurrentPlayer());

        if (currentState == GameState.IN_PROGESS) {
            turnManager.switchToNextPlayer();
        }
    }

    private void handleGameOver() {
        console.displayBoard(board);
        switch (currentState) {
            case WIN:
                console.displayWinner(turnManager.getCurrentPlayer());
                break;
            case DRAW:
                console.displayDraw();
                break;
            default:
                break;
        }
    }
}

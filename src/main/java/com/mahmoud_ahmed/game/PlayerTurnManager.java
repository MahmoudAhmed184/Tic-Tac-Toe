package com.mahmoud_ahmed.game;

import com.mahmoud_ahmed.model.Player;
import java.util.ArrayList;
import java.util.List;

public class PlayerTurnManager {
    private final List<Player> players;
    private int currentPlayerIndex;

    public PlayerTurnManager(int numberOfPlayers) {
        this.players = new ArrayList<>(numberOfPlayers);
        this.currentPlayerIndex = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void switchToNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}

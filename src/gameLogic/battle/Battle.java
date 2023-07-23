package gameLogic.battle;

import java.util.List;

public class Battle {
    private Player player;
    private Location location;
    private List<Opponent> opponents;
    private Worldstate worldstate;
    private UI ui;
    
    // Additional Attributes
    private boolean isPlayerTurn;
    private boolean isBattleOver;

    public Battle(Player player, Location location, List<Opponent> opponents, Worldstate worldstate, UI ui) {
        this.player = player;
        this.location = location;
        this.opponents = opponents;
        this.worldstate = worldstate;
        this.ui = ui;
        
        this.isPlayerTurn = true; // Initialize battle with player's turn
        this.isBattleOver = false;
    }

    // Other attributes specific to the battle, e.g., weather conditions, turn count, etc.

    public void startBattle() {
        ui.displayMessage("A battle has begun!");
        while (!isBattleOver) {
            if (isPlayerTurn) {
                playerTurn();
            } else {
                for (Opponent opponent : opponents) {
                    if (!isBattleOver) {
                        opponentTurn(opponent);
                    } else {
                        break;
                    }
                }
            }
            // Check if the battle is over after each turn
            checkBattleStatus();
        }
        endBattle();
    }

    private void playerTurn() {
        // Logic for the player's turn in the battle
        ui.displayMessage("It's your turn. Choose an action:");
        // Present options to the player through the UI's handle_input method
        List<String> options = /* ... */; // List of available actions
        int chosenAction = ui.handleInput(options);

        // Handle the player's chosen action
        // Update player and opponent states accordingly
        // Apply damage, healing, etc.

        isPlayerTurn = false; // End the player's turn
    }

    private void opponentTurn(Opponent opponent) {
        // Logic for the opponent's turn in the battle
        ui.displayMessage("It's " + opponent.getName() + "'s turn.");
        // Determine the opponent's action (e.g., attack, defend, use a skill, etc.)

        // Handle the opponent's chosen action
        // Update player and opponent states accordingly
        // Apply damage, healing, etc.
    }

    private void checkBattleStatus() {
        // Check for victory conditions, defeat conditions, or other battle-ending conditions
        // Set isBattleOver to true if the battle should end
    }

    private void endBattle() {
        // Logic to end the battle and clean up any resources or states related to the battle
        if (player.isAlive()) {
            ui.displayMessage("You have won the battle!");
            // Award experience points, items, or other rewards to the player
        } else {
            ui.displayMessage("You have been defeated!");
            // Handle defeat, e.g., respawn at a checkpoint, return to the main menu, etc.
        }
    }

    // Other helper methods specific to the battle, e.g., calculating damage, checking for victory conditions, etc.
}
package com.rpg.arena.battleground;

import CharacterGenerator.Character;

public interface Battleground {

    void beginFight(Character character1, Character character2);

    /**
     * Confirms if the battle is still running
     * @return true if characters are alive
     */
    boolean isStillRunning();

    /**
     * Runs the battle and switches rounds
     * @return String "Remaing health of player is..."
     */
    String getNextRound();

    /**
     * Checks if any characters are alive
     * @return living Character
     */
    Character getWinner();

    int getFirstCharAttackPar();
    int getFirstCharDefendPar();
    int getSecondCharAttackPar();
    int getSecondCharDefendPar();

    String getName();

}

package com.rpg.arena;

public interface Battleground {

    void beginFight(Character character1, Character character2);

    /**
     * Confirms if the battle is still running
     * @return true if characters are alive
     */
    boolean isStillRunning();
    String getNextRound();
    Character getWinner();
    int getFirstCharAttackPar();
    int getFirstCharDefendPar();
    int getSecondCharAttackPar();
    int getSecondCharDefendPar();

}

package com.rpg.arena;

public class Battlefield implements Battleground{

    Character playerCharacter;
    Character enemyCharacter;
    boolean round = false;

    public void beginFight(Character playerCharacter, Character enemyCharacter) {
        this.playerCharacter = playerCharacter;
        this.enemyCharacter = enemyCharacter;

    }

    public boolean isStillRunning() {

        if (playerCharacter.isAlive() && enemyCharacter.isAlive()) {
            return true;
        }
        return false;
    }

    public String getNextRound(){

        if(round == false){
            int remainingHealth = enemyCharacter.characterDefend(playerCharacter.characterAttack() + getFirstCharAttackPar() - getSecondCharDefendPar());
            round = !round;
            return "Remaining health of " + enemyCharacter.getName() + " is " + remainingHealth;
        }
        else {
            int remainingHealth = playerCharacter.characterDefend(enemyCharacter.characterAttack() + getSecondCharAttackPar() - getFirstCharDefendPar());
            round = !round;
            return "Remaining health of " + playerCharacter.getName() + " is " + remainingHealth;
        }

    }

    public Character getWinner(){
        if (playerCharacter.isAlive()) {
            return playerCharacter;
        }
        else {
            return enemyCharacter;
        }
    }

    public int getFirstCharAttackPar() {
        return 0;
    }

    public int getFirstCharDefendPar() {
        return 0;
    }

    public int getSecondCharAttackPar() {
        return 0;
    }

    public int getSecondCharDefendPar() {
        return 0;
    }

}

package com.rpg.arena;

public class Battlefield {

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
            int remainingHealth = enemyCharacter.characterDefend(playerCharacter.characterAttack());
            round = !round;
            return "Remaining health of " + enemyCharacter.getName() + " is " + remainingHealth;
        }
        else {
            int remainingHealth = playerCharacter.characterDefend(enemyCharacter.characterAttack());
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

}

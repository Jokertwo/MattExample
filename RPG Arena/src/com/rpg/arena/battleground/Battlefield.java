package com.rpg.arena.battleground;

import CharacterGenerator.Character;

import java.util.Random;

public class Battlefield implements Battleground{

    private Character playerCharacter;
    private Character enemyCharacter;
    private boolean round = false;

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

        if(!round){
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

    public Battleground getRandomBattleground() {
        Battleground swamp = new Swamp();
        Battleground forest = new Forest();
        Battleground ocean = new Ocean();

        Battleground[] battlegrounds = {swamp, forest, ocean};
        Random r = new Random();
        int randomNumber = Math.abs(r.nextInt());

        randomNumber = randomNumber % battlegrounds.length;

        return battlegrounds[randomNumber];
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

    public String getName() {
        return "battlefield";
    }

}

package com.rpg.arena.battleground;

public class Ocean extends Battlefield {

    @Override
    public int getSecondCharAttackPar() {
        return -3;
    }

    @Override
    public int getFirstCharAttackPar() {
        return -2;
    }

    @Override
    public int getFirstCharDefendPar() {
        return -3;
    }

    @Override
    public int getSecondCharDefendPar() {
        return -2;
    }

    @Override
    public String getName(){
        return "Ocean";
    }
}

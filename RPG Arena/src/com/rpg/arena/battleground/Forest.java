package com.rpg.arena.battleground;

public class Forest extends Battlefield {

    @Override
    public int getSecondCharAttackPar() {
        return 5;
    }

    @Override
    public int getSecondCharDefendPar() {
        return -5;
    }

    @Override
    public int getFirstCharAttackPar() {
        return -2;
    }

    @Override
    public int getFirstCharDefendPar() {
        return 2;
    }

    @Override
    public String getName(){
        return "Forest";
    }
}

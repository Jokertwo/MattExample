package com.rpg.arena.battleground;

public class Swamp extends Battlefield {

    @Override
    public int getSecondCharAttackPar() {
        return 5;
    }

    @Override
    public int getFirstCharAttackPar() {
        return -5;
    }

    @Override
    public String getName(){
        return "Swamp";
    }
}

package com.rpg.arena;

public class Swamp extends Battlefield {

    @Override
    public int getSecondCharAttackPar() {
        return 5;
    }

    @Override
    public int getFirstCharAttackPar() {
        return -5;
    }
}

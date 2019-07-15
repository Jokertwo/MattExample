package com.rpg.arena;

public enum Weapons {

    SWORD(0),
    AXE(1);



    private int index;

    private Weapons(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

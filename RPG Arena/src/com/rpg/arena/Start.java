package com.rpg.arena;

public class Start {

    public static void main(String[] args) {

        Character character1 = new Character("Pikachu", 50, 6, 4);
        Character character2 = new Character("Charmander", 25, 3, 2);

        Weapon weapon1 = new Weapon("Tail Whip", 2, 1);
        Weapon weapon2 = new Weapon("Fire Breath", 3, 3);

        character1.takeWeapon(Arm.RIGHT, weapon1);
        character2.takeWeapon(Arm.LEFT, weapon2);

        Battlefield battlefield = new Battlefield();

        battlefield.beginFight(character1, character2);

        System.out.println(runBattle(battlefield).nameToString() + " is the winner!");
    }

    public static Character runBattle(Battlefield battlefield) {

        while (battlefield.isStillRunning()){
            System.out.println(battlefield.getNextRound());
        }

        Character winner = battlefield.getWinner();

        return winner;
    }

}
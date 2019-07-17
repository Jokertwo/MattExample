package com.rpg.arena;

import java.util.Scanner;

public class Start {

    public static void main(String args[]) {

        XMLWriter.createXMLFile();

        Scanner input = new Scanner(System.in);

        /*
        //Build character 1
        System.out.println("Define Character 1");
        Character character1 = loadCharacter(input);

        //Build character 2
        System.out.println("Define Character 2");
        Character character2 = loadCharacter(input);

        //Build weapon and assign it to character 1 right hand
        System.out.println("Define right hand weapon for " + character1.getName());
        character1.takeWeapon(Arm.RIGHT, loadWeapon(input));

        //Build weapon and assign it to character 1 left hand
        System.out.println("Define left hand weapon for " + character1.getName());
        character1.takeWeapon(Arm.LEFT, loadWeapon(input));

        //Build weapon and assign it to character 2 right hand
        System.out.println("Define right hand weapon for " + character2.getName());
        character2.takeWeapon(Arm.RIGHT, loadWeapon(input));

        //Build weapon and assign it to character 2 left hand
        System.out.println("Define left hand weapon for " + character2.getName());
        character2.takeWeapon(Arm.LEFT, loadWeapon(input));
         */

        //Init battlefield
        Battlefield battlefield = new Battlefield();

        //Put characters in battlefield to die
        battlefield.beginFight(character1, character2);

        //Print the result
        System.out.println(runBattle(battlefield).getName() + " is the winner!");

    }

    public static Character runBattle(Battlefield battlefield) {

        while (battlefield.isStillRunning()){
            System.out.println(battlefield.getNextRound());
        }

        Character winner = battlefield.getWinner();

        return winner;
    }

    public static Character loadCharacter(Scanner sc) {

        System.out.println("Enter name for Character");
        String charName = sc.nextLine();

        System.out.println("Enter power for Character");
        int attackPower = Integer.parseInt(sc.nextLine());

        System.out.println("Enter defense for Character");
        int defense = Integer.parseInt(sc.nextLine());

        System.out.println("Enter health of Character");
        int health = Integer.parseInt(sc.nextLine());

        return new Character(charName, health, attackPower, defense);
    }

    public static Weapon loadWeapon(Scanner sc) {

        System.out.println("Enter name for weapon");
        String weaponName = sc.nextLine();

        if(weaponName.trim().isEmpty()){
            return null;
        }

        System.out.println("Enter power for Weapon");
        int attackPower = Integer.parseInt(sc.nextLine());

        System.out.println("Enter defense for Weapon");
        int defense = Integer.parseInt(sc.nextLine());

        return new Weapon(weaponName, attackPower, defense);
    }

}


package com.rpg.arena;

import java.util.Scanner;


public class InputCharacters {

    private Character character1;
    private Character character2;

    public void inputCharactersManual(Scanner input) {

        //Build character 1
        System.out.println("Define Character 1");
        character1 = loadCharacter(input);

        //Build weapon and assign it to character 1 right hand
        System.out.println("Define right hand weapon for " + character1.getName());
        character1.takeWeapon(Arm.RIGHT, loadWeapon(input));

        //Build weapon and assign it to character 1 left hand
        System.out.println("Define left hand weapon for " + character1.getName());
        character1.takeWeapon(Arm.LEFT, loadWeapon(input));

        //Build character 2
        System.out.println("Define Character 2");
        character2 = loadCharacter(input);


        //Build weapon and assign it to character 2 right hand
        System.out.println("Define right hand weapon for " + character2.getName());
        character2.takeWeapon(Arm.RIGHT, loadWeapon(input));

        //Build weapon and assign it to character 2 left hand
        System.out.println("Define left hand weapon for " + character2.getName());
        character2.takeWeapon(Arm.LEFT, loadWeapon(input));

    }

    public Character loadCharacter(Scanner sc) {

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

    public Weapon loadWeapon(Scanner sc) {

        System.out.println("Enter name for weapon");
        String weaponName = sc.nextLine();

        if (weaponName.trim().isEmpty()) {
            return null;
        }

        System.out.println("Enter power for Weapon");
        int attackPower = Integer.parseInt(sc.nextLine());

        System.out.println("Enter defense for Weapon");
        int defense = Integer.parseInt(sc.nextLine());

        return new Weapon(weaponName, attackPower, defense);
    }

    public Character[] getCharacters() {
        Character[] characters = new Character[2];
        characters[0] = character1;
        characters[1] = character2;

        return characters;
    }
}

package com.rpg.arena;

import CharacterGenerator.CharacterGen;
import CharacterGenerator.Weapon;
import com.rpg.arena.battleground.Battleground;
import com.rpg.arena.battleground.Forest;
import com.rpg.arena.battleground.Swamp;
import com.rpg.arena.battleground.Ocean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import CharacterGenerator.Character;

import static CharacterGenerator.Arm.LEFT;
import static CharacterGenerator.Arm.RIGHT;

public class Start {

    public static void main(String args[]) {

        Scanner input = null;

        if(args.length == 0){
            input = new Scanner(System.in);
        }
        else {
            String argument1 = args[0];
            File file = new File(argument1);
            try {
                input = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        /* LinkedList battlegrounds = new LinkedListImpl(); */

        //Choose a battlefield randomly and init
        Battleground swamp = new Swamp();
        Battleground forest = new Forest();
        Battleground ocean = new Ocean();

        Battleground[] battlegrounds = {swamp, forest, ocean};
        Random r = new Random();
        int randomNumber = Math.abs(r.nextInt());

        randomNumber = randomNumber % battlegrounds.length;
        Battleground battlefield = battlegrounds[randomNumber];
        //Put characters in battlefield to die

        //Create the player character
        Scanner playerInput = new Scanner(System.in);
        CharacterGen characterGenerator = new CharacterGen();
        Character player = characterGenerator.loadPlayer(playerInput);
        System.out.println("Equip Left weapon:");
        player.takeWeapon(LEFT, characterGenerator.loadPlayerWeapon(playerInput));
        System.out.println("Equip Right weapon:");
        player.takeWeapon(RIGHT, characterGenerator.loadPlayerWeapon(playerInput));
        playerInput.close();

        //Compile the ArrayLists of enemies and weapons from the files
        Scanner enemyInput = null;
        File enemyList = new File("C:\\Users\\Matt\\Documents\\CharacterGenerator\\src\\enemies.txt");
        File weaponList = new File("C:\\Users\\Matt\\Documents\\CharacterGenerator\\src\\weapons.txt");
        try {
            enemyInput = new Scanner(enemyList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        characterGenerator.setEnemyList(enemyInput);

        Scanner weaponInput = null;
        try {
            weaponInput = new Scanner(weaponList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        characterGenerator.setWeaponList(weaponInput);

        //Get some random character from the ArrayList and assign them some random weapons.
        Character enemy = characterGenerator.getRandomCharacter();
        Weapon enemyLeftWeapon = characterGenerator.getRandomWeapon();
        Weapon enemyRightWeapon = characterGenerator.getRandomWeapon();

        //Send the characters to fight to the death
        System.out.println("Fighting: " + enemy.getName());
        if (enemyLeftWeapon == null) {
            System.out.println(enemy.getName() + "has no weapon in left hand.");
        } else
        {
            enemy.takeWeapon(LEFT, enemyLeftWeapon);
            System.out.println(enemy.getName() + " picked up " + enemyLeftWeapon.getName() + " in left hand.");
        }
        if (enemyRightWeapon == null) {
            System.out.println(enemy.getName() + " has no weapon in right hand.");
        } else
        {
            enemy.takeWeapon(RIGHT, enemyRightWeapon);
            System.out.println(enemy.getName() + " picked up " + enemyRightWeapon.getName() + " in left hand.");
        }
        battlefield.beginFight(player, enemy);

        //Print the result
        System.out.println(runBattle(battlefield).getName() + " is the winner!");

    }

    public static Character runBattle(Battleground battlefield) {

        System.out.println("Bettleground set to: " + battlefield.getName());

        while (battlefield.isStillRunning()){
            System.out.println(battlefield.getNextRound());
        }

        Character winner = battlefield.getWinner();

        return winner;
    }



}


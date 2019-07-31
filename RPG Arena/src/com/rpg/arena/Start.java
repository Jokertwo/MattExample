package com.rpg.arena;

import CharacterGenerator.*;
import CharacterGenerator.Character;
import com.aveco.generator.MatrixGenerator;
import com.aveco.generator.MatrixGeneratorImpl;
import com.aveco.generator.Size;
import com.rpg.arena.battleground.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import static CharacterGenerator.Arm.LEFT;
import static CharacterGenerator.Arm.RIGHT;

public class Start {

    public static void main(String[] args) {

        MatrixGenerator matrixGenerator = new MatrixGeneratorImpl();
        String[][] matrix = matrixGenerator.generateMatrix(Size.SMALL);
        Scanner sc = new Scanner(System.in);
        PlayerMove playerMover = new PlayerMove();
        int enemiesRemaining = 4;

        //Create the player character
        CharacterGen characterGenerator = new CharacterGen();
        Character player = characterGenerator.loadPlayer(sc);
        System.out.println("Equip Left weapon:");
        player.takeWeapon(LEFT, characterGenerator.loadPlayerWeapon(sc));
        System.out.println("Equip Right weapon:");
        player.takeWeapon(RIGHT, characterGenerator.loadPlayerWeapon(sc));

        //Draw the first dungeon
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        //Start the game
        while (player.isAlive() && enemiesRemaining != 0){
            matrix = playerMover.playerMove(matrix, sc.nextLine());

            //Check if a fight was initiated
            if(playerMover.getFight()){
                Battleground battlefield = new Battlefield();
                battlefield = battlefield.getRandomBattleground();

                //Compile the ArrayLists of enemies and weapons from the files
                Scanner enemyInput = null;
                File enemyList = new File("C:\\Users\\Matt\\Documents\\CharacterGenerator\\src\\enemies.txt");
                File weaponList = new File("C:\\Users\\Matt\\Documents\\CharacterGenerator\\src\\weapons.txt");
                try {
                    enemyInput = new Scanner(enemyList);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if (enemyInput != null) characterGenerator.setEnemyList(enemyInput);

                Scanner weaponInput = null;
                try {
                    weaponInput = new Scanner(weaponList);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if (weaponInput != null) characterGenerator.setWeaponList(weaponInput);

                //Get some random character from the ArrayList and assign them some random weapons.
                Character enemy = characterGenerator.getRandomCharacter();
                Weapon enemyLeftWeapon = characterGenerator.getRandomWeapon();
                Weapon enemyRightWeapon = characterGenerator.getRandomWeapon();

                //Send the characters to fight to the death
                System.out.println("Fighting: " + enemy.getName());
                if (enemyLeftWeapon == null) System.out.println(enemy.getName() + "has no weapon in left hand.");
                else
                {
                    enemy.takeWeapon(LEFT, enemyLeftWeapon);
                    System.out.println(enemy.getName() + " picked up " + enemyLeftWeapon.getName() + " in left hand.");
                }

                if (enemyRightWeapon == null) System.out.println(enemy.getName() + " has no weapon in right hand.");
                else {
                    enemy.takeWeapon(RIGHT, enemyRightWeapon);
                    System.out.println(enemy.getName() + " picked up " + enemyRightWeapon.getName() + " in left hand.");
                }
                battlefield.beginFight(player, enemy);

                if (battlefield.getWinner() == player) enemiesRemaining = enemiesRemaining - 1;

                //Print the result
                System.out.println(runBattle(battlefield).getName() + " is the winner!");
            }

            //Reset the fight status indicator
            playerMover.endFight();

            if(player.isAlive()){
                for(int i = 0; i < matrix.length; i++) {
                    for(int j = 0; j < matrix[i].length; j++) {
                        System.out.print(matrix[i][j]);
                    }
                    System.out.println();
                }
            }
        }

        if(player.isAlive()) System.out.println("You Win!");
        else System.out.println("Game Over");
    }

    public static Character runBattle(Battleground battlefield) {

        System.out.println("Bettleground set to: " + battlefield.getName());

        while (battlefield.isStillRunning()) System.out.println(battlefield.getNextRound());

        Character winner = battlefield.getWinner();

        return winner;
    }



}


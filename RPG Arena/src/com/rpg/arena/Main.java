package com.rpg.arena;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {




    /*
    public Main() {


        //INIT
        //visible window
        JFrame frame = new JFrame("RPG Arena");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(400,200);

        SettingsFields setupGame = new SettingsFields();
        JPanel container = new JPanel(new BorderLayout());


        container.add(setupGame.getSettingsScreen(),BorderLayout.CENTER);

        frame.add(container);
        //set window visible
        frame.setVisible(true);

        //Construct weapon and enemy objects
        InitWeapons();
        InitEnemies();

        //set the player's name and weapon
        SettingsFields.enterGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameField = SettingsFields.inputName.getText();
                String weaponField = (String)SettingsFields.chooseWeapon.getSelectedItem();
                String enemyField = (String)SettingsFields.chooseEnemy.getSelectedItem();




                Character playerCharacter = new Character(nameField, 100, chosenWeapon);

                TextFields playerData = new TextFields("Player Stats", nameField, weaponField, 100, playerCharacter.weapon.attack, playerCharacter.weapon.defend);
                TextFields enemyData = new TextFields("Enemy Stats:", enemyField, weaponField, chosenEnemy.characterHealth, chosenEnemy.weapon.attack, chosenEnemy.weapon.defend );

                JButton attackButton = new JButton("Attack!");
                JLabel battleLog = new JLabel("You dealt a DMG. Enemy dealt b DMG");

                container.remove(setupGame.getSettingsScreen());
                container.add(playerData.getDashboard(),BorderLayout.CENTER);
                container.add(enemyData.getDashboard(),BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
               // container.add(attackButton);

            }
        });
    }
    public Weapon[] InitWeapons() {
        //Initialize weapon objects
        Weapon[] weaponArray = new Weapon[6];

        weaponArray[Weapons.SWORD.getIndex()] = new Weapon("Sword", 10, 3);
        weaponArray[1] = new Weapon("Axe", 8, 5);
        weaponArray[2] = new Weapon("Mace", 7, 6);
        weaponArray[3] = new Weapon("Gloves", 13, 0);

        Weapon sword = new Weapon("Sword", 10, 3);
        Weapon axe = new Weapon("Axe", 8, 5);
        Weapon mace = new Weapon("Mace", 7, 6);
        Weapon gloves = new Weapon("Gloves", 13, 0);
        Weapon rocketLauncher = new Weapon("Rocket Launcher", 25, 0);
        Weapon gandalfStaff = new Weapon("Gandalf's Staff", 25, 10);
    }

    public Character[] InitEnemies() {
        //initialize character objects
        Character goblin = new Character("Goblin", 50, mace);
        Character imp = new Character("Imp", 60, gloves);
        Character harpy = new Character("Harpy", 80, axe);
        Character demon = new Character("Demon", 100, sword);
        Character gandalf = new Character("Gandalf", 400, gandalfStaff);
    }

    public Weapon getWeapon(String weaponField){

        switch(weaponField) {
            case "Sword":
                return sword;
            case "Axe":
                return axe;
            case "Mace":
                return mace;
            case "Gloves":
                return gloves;
            case "Rocket Launcher":
                return rocketLauncher;
        }

    }
    public Character getEnemy {

        switch(enemyField) {
            case "Goblin":
                return goblin;
            case "Imp":
                return imp;
            case "Harpy":
                return harpy;
            case "Demon":
                return demon;
            case "Gandalf":
                return gandalf;
        }
    }
*/
}


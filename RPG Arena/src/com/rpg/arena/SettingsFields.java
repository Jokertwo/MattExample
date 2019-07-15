package com.rpg.arena;

import javax.swing.*;

public class SettingsFields {

    private String[] enemies = {"Goblin", "Imp", "Harpy", "Demon", "Gandalf"};
    private String[] weapons = {"Sword", "Axe", "Mace", "Gloves", "Rocket Launcher"};

    private JLabel playerNameAsk;
    static JTextField inputName;
    private JLabel chooseWeaponAsk;
    static JComboBox chooseWeapon;
    private JLabel chooseEnemyAsk;
    static JComboBox chooseEnemy;
    static JButton enterGame;
    private JPanel settingsScreen;

    public SettingsFields() {

        this.playerNameAsk = new JLabel("What is your name, brave knight?");
        this.inputName = new JTextField(10);
        this.chooseWeaponAsk = new JLabel("What is your weapon of choice?");
        this.chooseWeapon = new JComboBox(weapons);
        this.chooseEnemyAsk = new JLabel("Who will you battle?");
        this.chooseEnemy = new JComboBox(enemies);
        this.enterGame = new JButton("To battle!");

        settingsScreen = new JPanel();
        settingsScreen.setLayout(new BoxLayout(settingsScreen, BoxLayout.PAGE_AXIS));

        settingsScreen.add(this.playerNameAsk);
        settingsScreen.add(this.inputName);
        settingsScreen.add(this.chooseWeaponAsk);
        settingsScreen.add(this.chooseWeapon);
        settingsScreen.add(this.chooseEnemyAsk);
        settingsScreen.add(this.chooseEnemy);
        settingsScreen.add(this.enterGame);
    }

    public JPanel getSettingsScreen() {
        return settingsScreen;
    }
}

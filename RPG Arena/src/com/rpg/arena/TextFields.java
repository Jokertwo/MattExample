package com.rpg.arena;

import javax.swing.*;

public class TextFields {

    private JLabel statsStatement;
    private JLabel name;
    private JLabel weapon;
    private JLabel hitPoints;
    private JLabel attack;
    private JLabel defense;
    private JPanel dashboard;

    public TextFields(String statsStatement, String name, String weapon, int hitPoints, int attack, int defense){

        this.statsStatement = new JLabel(statsStatement);
        this.name = new JLabel(name);
        this.weapon = new JLabel(weapon);
        this.hitPoints = new JLabel("HP: " + hitPoints);
        this.attack = new JLabel("ATK: " + attack);
        this.defense = new JLabel("DEF: " + defense);
        
        dashboard = new JPanel();
        dashboard.setLayout(new BoxLayout(dashboard, BoxLayout.PAGE_AXIS));

        dashboard.add(this.statsStatement);
        dashboard.add(this.name);
        dashboard.add(this.weapon);
        dashboard.add(this.hitPoints);
        dashboard.add(this.attack);
        dashboard.add(this.defense);

    }

    public JPanel getDashboard(){
        return dashboard;
    }

}

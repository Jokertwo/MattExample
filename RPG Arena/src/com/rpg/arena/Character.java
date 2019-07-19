package com.rpg.arena;

public class Character {

    private String characterName;
    private int characterHealth;
    private int attackDamage;
    private int defense;
    private CharacterArm leftArm;
    private CharacterArm rightArm;


    public Character(String name, int health, int attack, int defense){
        this.characterName = name;
        this.characterHealth = health;
        this.attackDamage = attack;
        this.defense = defense;
        this.leftArm = new CharacterArm(Arm.LEFT);
        this.rightArm = new CharacterArm(Arm.RIGHT);
    }

    public String getName(){
        return characterName;
    }

    boolean takeWeapon(Arm arm, Weapon weapon) {

        if(arm == rightArm.getArm()){
            if(rightArm.getWeapon() == null){
                rightArm.setWeapon(weapon);
                return true;
            }
        }
        if(arm == leftArm.getArm()){
            if(leftArm.getWeapon() == null){
                leftArm.setWeapon(weapon);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param enemyAttack
     * @return remainingHealth
     */
        int characterDefend(int enemyAttack) {

        int remainingHealth = characterHealth;
        int totalDefense = 0;

        if(enemyAttack <= 0){
            return  remainingHealth;
        }

        if(leftArm.hasWeapon() == true){
            totalDefense = totalDefense + leftArm.getWeapon().getDefend();
        }
        if(rightArm.hasWeapon() == true){
            totalDefense = totalDefense + rightArm.getWeapon().getDefend();
        }

        totalDefense = totalDefense + defense;

        if(totalDefense < enemyAttack){
            remainingHealth = remainingHealth - (enemyAttack - totalDefense);
        }


        characterHealth = remainingHealth;
        return characterHealth;
    }

    int characterAttack(){

        int totalAttack = attackDamage;

        if(leftArm.hasWeapon() == true){
            totalAttack = totalAttack + leftArm.getWeapon().getAttack();
        }
        if(rightArm.hasWeapon() == true){
            totalAttack = totalAttack + rightArm.getWeapon().getAttack();
        }

        return totalAttack;
    }

    boolean isAlive() {

        if (characterHealth > 0){
            return true;
        }
        else {
            return false;
        }
    }
}

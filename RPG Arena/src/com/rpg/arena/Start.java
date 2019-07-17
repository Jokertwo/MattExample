package com.rpg.arena;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Start {

    public static boolean useXML;

    public static void main(String args[]) {

        Scanner input = null;

        if(args.length == 0){
            useXML = false;
            input = new Scanner(System.in);
        }
        else {
            String argument1 = args[0];
            useXML = true;
            File file = new File(argument1);
            try {
                input = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //XMLWriter.createXMLFile();
        }

        //Init battlefield
        Battlefield battlefield = new Battlefield();

        //Put characters in battlefield to die
        InputCharacters characterInputs = new InputCharacters();
        characterInputs.inputCharactersManual(input);
        Character[] characters = characterInputs.getCharacters();
        battlefield.beginFight(characters[0], characters[1]);

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



}


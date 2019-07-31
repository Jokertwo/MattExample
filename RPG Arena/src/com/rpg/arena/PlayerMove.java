package com.rpg.arena;

import com.aveco.generator.MatrixGenerator;
import com.rpg.arena.battleground.Battlefield;
import com.rpg.arena.battleground.Battleground;

public class PlayerMove {

    private String[][] matrix;
    private int[] nextMove = new int[2];
    private boolean startFight = false;

    public String[][] playerMove(String[][] matrix, String keyPress) {
        this.matrix = matrix;
        int[] playerLocation = locatePlayer();

        switch(keyPress){
            case "w":
                nextMove[0] = playerLocation[0]-1;
                nextMove[1] = playerLocation[1];
                break;
            case "a":
                nextMove[0] = playerLocation[0];
                nextMove[1] = playerLocation[1]-1;
                break;
            case "s":
                nextMove[0] = playerLocation[0]+1;
                nextMove[1] = playerLocation[1];
                break;
            case "d":
                nextMove[0] = playerLocation[0];
                nextMove[1] = playerLocation[1]+1;
                break;
            default:
                System.out.println("Invalid move.");
                break;
        }

        if(legalMove(matrix[nextMove[0]][nextMove[1]])){
            if( matrix[nextMove[0]][nextMove[1]].equals(MatrixGenerator.ENEMY)) startFight = true;

            matrix[nextMove[0]][nextMove[1]] = MatrixGenerator.PLAYER;
            matrix[playerLocation[0]][playerLocation[1]] = MatrixGenerator.EMPTY;
        }

        return matrix;
    }

    /**
     * Locate the player in the matrix
     * ...return a boolean which identifies if the player was found or not.
     * @return boolean playerFound
     */
    private int[] locatePlayer() {

        int[] location = new int[2];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == MatrixGenerator.PLAYER){
                    location[0] = i;
                    location[1] = j;
                    return location;
                }
            }
        }
        return location;
    }

    private boolean legalMove(String nextMove) {
        if(nextMove.equals(MatrixGenerator.EMPTY) || nextMove.equals(MatrixGenerator.ENEMY)){
            return true;
        }
        return false;
    }

    public boolean getFight() {return startFight;}

    public void endFight() {startFight = false;}
}

package com.rpg.arena.linkedList;


import com.rpg.arena.battleground.Battleground;

public class Node {

    private Battleground value;
    private Node nextNode;

    public Node(Battleground battleground, Node nextNode){
        this.nextNode = nextNode;
        this.value = battleground;
    }



    public Battleground getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

}

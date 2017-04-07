package com.maxGroup.Meeting.HomeTask11_1;

public class Chess implements IGame {
    public int moves;
    public int MOVES;

    public Chess(int moves) {
        this.moves = moves;
        MOVES = 5;
    }

    public boolean move() {
        if (MOVES > moves) {
            System.out.println("Здійснено хід у шахматах");
            return true;
        }
        System.out.println("Неможливо походити");
        return false;
    }
}

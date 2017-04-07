package com.maxGroup.Meeting.HomeTask11_1;

public class Checkers implements IGame {
    public int moves;
    public int MOVES;

    public Checkers(int moves) {
        this.moves = moves;
        MOVES = 3;
    }

    public boolean move() {
        if (MOVES > moves) {
            moves = MOVES;
            System.out.println("Здійснено хід у шахах");
            return true;
        }
        System.out.println("Неможливо походити");
        return false;
    }
}

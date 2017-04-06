package com.maxGroup.Meeting.HomeTask11_1;

public class Checkers implements IGame {
    public int moves;
    public int MOVES;

    public Checkers(int moves, int MOVES) {
        this.moves = moves;
        this.MOVES = MOVES;
    }

    public boolean move() {
        if (MOVES - moves < 3 && MOVES - moves >= 0) {
            moves = MOVES;
            System.out.println("Перехід з " + moves + " до " + MOVES+" (шахмати)");
            return true;
        }
        System.out.println("Неможливо походити");
        return false;
    }
}

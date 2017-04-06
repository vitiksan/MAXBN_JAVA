package com.maxGroup.Meeting.HomeTask11_1;

public class Chess implements IGame {
    public int moves;
    public int MOVES;

    public Chess(int moves, int MOVES) {
        this.moves = moves;
        this.MOVES = MOVES;
    }

    public boolean move() {
        if (MOVES - moves == 1) {
            moves = MOVES;
            System.out.println("Перехід з " + moves + " до " + MOVES + " (шахи)");
            return true;
        }
        System.out.println("Неможливо походити");
        return false;
    }
}

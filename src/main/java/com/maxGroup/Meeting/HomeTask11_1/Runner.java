package com.maxGroup.Meeting.HomeTask11_1;

public class Runner {
    public static void main(String[] args) {
        Games.playGame(new CheckersFactory());
        Games.playGame(new ChessFactory());
    }
}

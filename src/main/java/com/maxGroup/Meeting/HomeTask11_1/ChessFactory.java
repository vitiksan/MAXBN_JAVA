package com.maxGroup.Meeting.HomeTask11_1;

public class ChessFactory implements IGameFactory {
    public IGame getGame() {
        IGame game = new Chess(1, 2);
        System.out.println("Почнемо гру в шахи!");
        return game;
    }
}

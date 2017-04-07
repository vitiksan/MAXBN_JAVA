package com.maxGroup.Meeting.HomeTask11_1;

public class CheckersFactory implements IGameFactory {
    public IGame getGame() {
        IGame game = new Checkers(1);
        System.out.println("Почнемо гру в шахи!");
        return game;
    }
}

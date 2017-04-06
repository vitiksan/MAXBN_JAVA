package com.maxGroup.Meeting.lesson12_abstractFactory;

public class TeamLiderFactory implements IManagerFactory {
    public IManager createManager() {
        return new TeamLider();
    }
}

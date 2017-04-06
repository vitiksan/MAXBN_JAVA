package com.maxGroup.Meeting.lesson12_abstractFactory;

public class ProjectManagerFactory implements IManagerFactory {
    public IManager createManager() {
        return new ProjectManager();
    }
}

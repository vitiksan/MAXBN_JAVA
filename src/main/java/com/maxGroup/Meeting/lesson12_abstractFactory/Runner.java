package com.maxGroup.Meeting.lesson12_abstractFactory;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<IEmployee> team = new ArrayList<IEmployee>();
        IDeveloperFactory developerFactory = createDevFactory("java");
        team.add(developerFactory.createDeveloper());
        IManagerFactory managerFactory = createManFactory("project");
        team.add(managerFactory.createManager());
        ITesterFactory testerFactory = createTestFactory("qa");
        team.add(testerFactory.createTester());
    }

    public static IDeveloperFactory createDevFactory(String devType) {
        if (devType.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (devType.equalsIgnoreCase("php")) {
            return new PhpDeveloperFactory();
        } else throw new RuntimeException(devType + " is not defined.");
    }

    public static IManagerFactory createManFactory(String manType) {
        if (manType.equalsIgnoreCase("project")) {
            return new ProjectManagerFactory();
        } else if (manType.equalsIgnoreCase("teamlider")) {
            return new TeamLiderFactory();
        } else throw new RuntimeException(manType + " is not defined.");
    }

    public static ITesterFactory createTestFactory(String testType) {
        if (testType.equalsIgnoreCase("qa")) {
            return new QaTesterFactory();
        } else if (testType.equalsIgnoreCase("qc")) {
            return new QcTesterFactory();
        } else throw new RuntimeException(testType + " is not defined.");
    }
}
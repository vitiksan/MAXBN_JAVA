package com.maxGroup.Meeting.lesson12_abstractFactory;

public class Runner {
    public static void main(String[] args) {
        IDeveloperFactory developerFactory = createDevFactory("java");
        IDeveloper developer = developerFactory.createDeveloper();
        developer.writeCode();
        IManagerFactory managerFactory = createManFactory("project");
        IManager manager = managerFactory.createManager();
        manager.createTask();
        ITesterFactory testerFactory = createTestFactory("qa");
        ITester tester = testerFactory.createTester();
        tester.debugCode();
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
package com.maxGroup.Meeting.lesson11_1;

public class Factory {
    public static void serviceCreator(IServiceFactory servFact){
        IService serv = servFact.newService();
        serv.show();
        serv.call();
    }
}

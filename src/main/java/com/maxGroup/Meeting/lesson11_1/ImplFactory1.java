package com.maxGroup.Meeting.lesson11_1;

public class ImplFactory1 implements IServiceFactory {
    public IService newService() {
        return new Impl1();
    }
}

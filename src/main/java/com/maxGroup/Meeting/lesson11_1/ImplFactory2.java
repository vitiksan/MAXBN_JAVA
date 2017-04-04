package com.maxGroup.Meeting.lesson11_1;

public class ImplFactory2 implements IServiceFactory {
    public IService newService() {
        return new Impl2();
    }
}

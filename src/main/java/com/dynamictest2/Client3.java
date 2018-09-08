package com.dynamictest2;

import java.lang.reflect.Proxy;

public class Client3 {
    public static void main(String[] args) {
        RealObject instance = new RealObject();

        ProxyObjcet invokeHandler = new ProxyObjcet(instance);

        ShareInterface2 invokeInstance = (ShareInterface2) Proxy.newProxyInstance(invokeHandler.getClass().getClassLoader(), new Class[]{ShareInterface.class, ShareInterface2.class}, invokeHandler);

        invokeInstance.sayHello2("CC");

    }
}

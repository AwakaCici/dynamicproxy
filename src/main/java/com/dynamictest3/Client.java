package com.dynamictest3;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
//        FooImpl instance1 = new FooImpl();
//        Foo proxy = (Foo) Proxy.newProxyInstance(instance1.getClass().getClassLoader(),
//                instance1.getClass().getInterfaces(), new CommonInvocationHander(instance1));
//        proxy.doAction();
        CommonInvocationHander hander = new CommonInvocationHander();
        Foo f = null;
        hander.setObject(new FooImpl());
        f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
                new Class[]{Foo.class}, hander);
        f.doAction();
        System.out.println("---------------------------");
        hander.setObject(new FooImpl2());
        f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
                new Class[]{Foo.class}, hander);
        f.doAction();
    }
}

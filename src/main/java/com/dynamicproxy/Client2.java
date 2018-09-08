package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client2 {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();

        InvocationHandler handler = new DynamicSubject(realSubject);

        Class<?> classType = handler.getClass();

        // 下面的代码一次性生成代理

        Subject instance = (Subject) Proxy.newProxyInstance(classType.getClassLoader(), realSubject.getClass().getInterfaces(), handler);

        instance.request();
    }
}

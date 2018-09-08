package com.dynamictest2;

import com.invoketest.Private2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyObjcet implements InvocationHandler {
    Object object;

    public ProxyObjcet(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre invoke");
        method.invoke(object, args);
        return null;
    }
}

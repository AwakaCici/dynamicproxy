package com.dynamictest3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CommonInvocationHander implements InvocationHandler {
    private Object object;

    public CommonInvocationHander(Object o) {
        this.object = o;
    }

    public CommonInvocationHander() {

    }

    public void setObject(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }
}

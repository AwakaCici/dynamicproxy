package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

public class VectorProxy implements InvocationHandler {
    private Object proxyobj;

    public VectorProxy(Object proxyobj) {
        this.proxyobj = proxyobj;
    }

    public static Object factory(Object obj) {
        Class<?> classType = obj.getClass();

        return Proxy.newProxyInstance(classType.getClassLoader(), classType.getInterfaces(), new VectorProxy(obj));
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before calling : " + method);

        if (args != null) {
            for (Object el : args) {
                System.out.println(el);
            }
        }

        Object obj = method.invoke(proxyobj, args);

        System.out.println("after calling + " + method);

        System.out.println("return obj " + obj);
        return obj;
    }

    public static void main(String[] args) {
        List v = (List) factory(new Vector());
        v.add("New");
        v.add("York");
        System.out.println(v);
    }
}

package com.dynamicproxy;

import com.dynamictest2.ProxyObjcet;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

public class VectorProxyReview implements InvocationHandler {
    // 真正的对象的引用
    Object realObj;

    public VectorProxyReview(Object realObj) {
        this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理模式invoke方法。可以附带属性" + method);
        return method.invoke(realObj, args);
    }

    static Object factory(Object obj) {
        Class classType = obj.getClass();
        // 返回一个接口的实例
        return Proxy.newProxyInstance(classType.getClassLoader(), classType.getInterfaces(), new VectorProxyReview(obj));
    }

    public static void main(String[] args) {
//        List list = new Vector();
        List obj = (List) factory(new Vector());
        obj.add("a");
        obj.remove(0);
        System.out.println(obj);
//        System.out.println(obj);
    }
}

package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 该代理类的内部属性是Object类型，实际使用的时候通过该类的构造方法传进来一个对象
 * 此外，该类还实现了Invoke方法，该方法的method的Invoke其实就是调用被代理对象将要执行的方法
 * 方法参数是sub
 */
public class DynamicSubject implements InvocationHandler {
    // 真正调用的对象类型
    private Object sub;

    public DynamicSubject(Object object) {
        this.sub = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling " + method);
        // 调用哪个真实对象的方法，传入真实的参数
        method.invoke(sub, args);

        System.out.println("after calling " + method);

        return null;
    }
}

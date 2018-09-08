package com.dynamictest2;

public class RealObject implements ShareInterface, ShareInterface2 {
    @Override
    public void sayHello(String name) {
        System.out.println("From Real Subject !! Hello " + name);
    }

    @Override
    public void sayHello2(String name) {
        System.out.println("From Real subjcet 2 ! hello + " + name);
    }
}

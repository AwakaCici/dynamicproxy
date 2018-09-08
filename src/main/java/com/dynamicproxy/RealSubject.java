package com.dynamicproxy;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("From Real Subjcet");
    }
}

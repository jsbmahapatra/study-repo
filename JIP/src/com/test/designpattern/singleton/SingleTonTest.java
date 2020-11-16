package com.test.designpattern.singleton;

public class SingleTonTest {
    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        EnumSingleton.doSomething();
        EnumSingleton.doSomething();
        EnumSingleton.doSomething();
    }
}

package com.test.designpattern.singleton;

public enum EnumSingleton {
    INSTANCE;

    public static void doSomething() {
        System.out.println("From EnumSingleton doSomething  ");
    }

}

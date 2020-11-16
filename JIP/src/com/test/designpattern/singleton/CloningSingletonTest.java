package com.test.designpattern.singleton;

public class CloningSingletonTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ThreadSafeLazySingleton singleton1 = ThreadSafeLazySingleton.getInstance();
        ThreadSafeLazySingleton singleton2 = (ThreadSafeLazySingleton) singleton1.clone();

        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}

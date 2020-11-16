package com.test.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingletonTest {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        ThreadSafeLazySingleton singletonOne = ThreadSafeLazySingleton.getInstance();
        ThreadSafeLazySingleton singletonTwo = null;

        Constructor[] constructors = ThreadSafeLazySingleton.class.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor constructor = constructors[i];
            constructor.setAccessible(true);
            singletonTwo = (ThreadSafeLazySingleton) constructor.newInstance();
            break;
        }

        System.out.println(singletonOne.hashCode());
        System.out.println(singletonTwo.hashCode());
    }
}

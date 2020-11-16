package com.test.designpattern.singleton;

import java.io.Serializable;

public class ThreadSafeLazySingleton implements Cloneable, Serializable {
    private static ThreadSafeLazySingleton instance;

    private ThreadSafeLazySingleton() {
    }

    public static ThreadSafeLazySingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeLazySingleton.class) {
                if (instance == null)
                    instance = new ThreadSafeLazySingleton();
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }

    // implement readResolve method
    protected Object readResolve() {
        return instance;
    }
}


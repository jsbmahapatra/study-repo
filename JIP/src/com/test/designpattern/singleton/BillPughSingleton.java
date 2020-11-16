package com.test.designpattern.singleton;

public class BillPughSingleton {
    private BillPughSingleton() {
    }

    public static BillPughSingleton getInstance() {
        return SingleTonHelper.INSTANCE;

    }

    private static class SingleTonHelper {
        private final static BillPughSingleton INSTANCE = new BillPughSingleton();
    }
}

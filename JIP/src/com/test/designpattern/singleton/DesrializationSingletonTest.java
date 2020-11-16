package com.test.designpattern.singleton;

import java.io.*;

public class DesrializationSingletonTest {
    public static void main(String[] args) {
        ThreadSafeLazySingleton instance = ThreadSafeLazySingleton.getInstance();
        ThreadSafeLazySingleton instance2 = null;
        try {
            ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("object.test"));
            objectOutput.writeObject(instance);
            objectOutput.close();

            ObjectInput objectInput = new ObjectInputStream(new FileInputStream("object.test"));
            instance2 = (ThreadSafeLazySingleton) objectInput.readObject();
        } catch (Exception ex) {

        }

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());


    }
}

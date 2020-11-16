package com.test.immutable;

public class Person {
    private String name;
    private int age;
    private Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        Address address1 = new Address(address.getHouseNo(), address.getPin());
        this.address = address1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return new Address(address.getHouseNo(), address.getPin());
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

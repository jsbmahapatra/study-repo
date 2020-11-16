package com.test.immutable;

public class Address {
    private String houseNo;
    private int pin;

    public Address(String houseNo, int pin) {
        this.houseNo = houseNo;
        this.pin = pin;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}

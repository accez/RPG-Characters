package com.company.ErrorHandling;

public class InvalidWeapon extends Exception {
    public InvalidWeapon(String message) {
        super(message);
    }
}

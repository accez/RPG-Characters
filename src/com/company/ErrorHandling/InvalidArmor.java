package com.company.ErrorHandling;

public class InvalidArmor extends Exception{
    public InvalidArmor(String message) {
        super(message);
    }
}

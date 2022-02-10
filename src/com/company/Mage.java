package com.company;

public class Mage extends Character {

    public Mage(String name) {
        super(name);
        attribute.strength = 1;
        attribute.dexterity = 1;
        attribute.intelligence = 8;
    }

    @Override
    public void levelUp() {
        attribute.strength += 1;
        attribute.dexterity += 1;
        attribute.intelligence += 5;
    }
}

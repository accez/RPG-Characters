package com.company;

public class Ranger extends Character {
    public Ranger(String name) {
        super(name);
        attribute.strength = 1;
        attribute.dexterity = 7;
        attribute.intelligence = 1;
    }

    @Override
    public void levelUp() {
        level += 1;
        attribute.strength += 1;
        attribute.dexterity += 5;
        attribute.intelligence += 1;
    }
}

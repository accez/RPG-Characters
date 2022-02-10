package com.company;

public class Rouge extends Character{

    public Rouge(String name){
        super(name);
        attribute.strength = 2;
        attribute.dexterity = 6;
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

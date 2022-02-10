package com.company;

public class Warrior extends Character{
    public  Warrior(String name){
        super(name);
        attribute.strength = 5;
        attribute.dexterity = 2;
        attribute.intelligence = 1;
    }
    @Override
    public void levelUp() {
        level += 1;
        attribute.strength += 3;
        attribute.dexterity += 2;
        attribute.intelligence += 1;
    }
}

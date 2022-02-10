package com.company;

public abstract class Character {
    String name;
    int level;
    PrimaryAttribute attribute = new PrimaryAttribute();

    public Character(String name){
        this.name = name;
        this.level = 1;
    }


    public abstract void levelUp();
}

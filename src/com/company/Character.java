package com.company;

public abstract class Character {
    private String name;
    private int level;
    public PrimaryAttribute attribute = new PrimaryAttribute();

    public Character(String name) {
        this.name = name;
        this.level = 1;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public abstract void levelUp();
}

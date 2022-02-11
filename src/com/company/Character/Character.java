package com.company.Character;

import com.company.Item.Item;

import java.util.HashMap;

public abstract class Character {
    final private String name;
    private int level;
    final private HashMap<Slot, Item> equipment = new HashMap<>();
    public PrimaryAttribute attribute = new PrimaryAttribute();

    public Character(String name) {
        this.name = name;
        this.level = 1;
    }


    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level) {

        this.level = level;
    }

    public String getName() {
        return name;
    }

    public abstract void levelUp();

    public HashMap<Slot, Item> getEquipment() {
        return equipment;
    }
}

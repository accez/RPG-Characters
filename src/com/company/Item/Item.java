package com.company.Item;

import com.company.Character.Slot;

public abstract class Item {
    private String name;
    private int requiredLevel;
    private Slot slot;

    public Item(String name, int requiredLevel, Slot slot) {
        setName(name);
        setRequiredLevel(requiredLevel);
        setSlot(slot);
    }

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}

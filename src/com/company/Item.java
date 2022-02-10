package com.company;

public abstract class Item {
    private String name;
    private int requiredLevel;
    private String slot;

    public Item(String name, int requiredLevel, String slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }
    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public String getSlot() {
        return slot;
    }
    public String setName(String name) {
        this.name = name;
        return name;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

}

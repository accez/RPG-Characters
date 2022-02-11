package com.company.Item.Armor;

import com.company.Character.Slot;
import com.company.Item.Item;
import com.company.Character.PrimaryAttribute;

public class Armor extends Item {
    ArmorTypes armorTypes;
    public PrimaryAttribute primaryAttribute = new PrimaryAttribute();
    public Armor(String name, int requiredLevel, Slot slot, ArmorTypes armorTypes) {
        super(name, requiredLevel, slot);
        this.armorTypes = armorTypes;
        primaryAttribute.setStrength(0);
        primaryAttribute.setDexterity(0);
        primaryAttribute.setIntelligence(0);
    }

    public ArmorTypes getArmorTypes() {
        return armorTypes;
    }

    public void setArmorTypes(ArmorTypes armorTypes) {
        this.armorTypes = armorTypes;
    }
}

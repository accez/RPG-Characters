package com.company.Armor;

import com.company.Item;
import com.company.PrimaryAttribute;

public class Armor extends Item {
    ArmorTypes armorTypes;
    public PrimaryAttribute primaryAttribute = new PrimaryAttribute();
    public Armor(String name, int requiredLevel, String slot,ArmorTypes armorTypes) {
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

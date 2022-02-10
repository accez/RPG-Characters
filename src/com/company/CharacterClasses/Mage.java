package com.company.CharacterClasses;

import com.company.Character;

public class Mage extends Character {
    public Mage(String name) {
        super(name);
        attribute.setStrength(1);
        attribute.setDexterity(1);
        attribute.setIntelligence(8);
    }

    @Override
    public void levelUp() {
        int level = getLevel();
        int strength =  attribute.getStrength();
        int dexterity = attribute.getDexterity();
        int intelligence = attribute.getIntelligence();
        level += 1;
        strength += 1;
        dexterity += 1;
        intelligence += 5;
        setLevel(level);
        attribute.setStrength(strength);
        attribute.setDexterity(dexterity);
        attribute.setIntelligence(intelligence);
    }
}

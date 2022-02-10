package com.company.CharacterClasses;

import com.company.Character;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        attribute.setStrength(5);
        attribute.setDexterity(2);
        attribute.setIntelligence(1);
    }

    @Override
    public void levelUp() {
        int level = getLevel();
        int strength = attribute.getStrength();
        int dexterity = attribute.getDexterity();
        int intelligence = attribute.getIntelligence();
        level += 1;
        strength += 3;
        dexterity += 2;
        intelligence += 1;
        setLevel(level);
        attribute.setStrength(strength);
        attribute.setDexterity(dexterity);
        attribute.setIntelligence(intelligence);
    }
}

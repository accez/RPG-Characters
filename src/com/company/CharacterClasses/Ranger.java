package com.company.CharacterClasses;

import com.company.Character;

public class Ranger extends Character {
    public Ranger(String name) {
        super(name);
        attribute.setStrength(1);
        attribute.setDexterity(7);
        attribute.setIntelligence(1);
    }

    @Override
    public void levelUp() {
        int level = getLevel();
        int strength =  attribute.getStrength();
        int dexterity = attribute.getDexterity();
        int intelligence = attribute.getIntelligence();
        level += 1;
        strength += 1;
        dexterity += 5;
        intelligence += 1;
        setLevel(level);
        attribute.setStrength(strength);
        attribute.setDexterity(dexterity);
        attribute.setIntelligence(intelligence);
    }
}

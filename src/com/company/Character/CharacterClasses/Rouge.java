package com.company.Character.CharacterClasses;

import com.company.Character.Character;

public class Rouge extends Character {

    public Rouge(String name, HeroType heroType, MainPrimaryAttribute mainPrimaryAttribute) {
        super(name, heroType, mainPrimaryAttribute);

        attribute.setStrength(2);
        attribute.setDexterity(6);
        attribute.setIntelligence(1);
    }

    @Override
    public void levelUp() {
        int level = getLevel();
        int strength = attribute.getStrength();
        int dexterity = attribute.getDexterity();
        int intelligence = attribute.getIntelligence();
        level += 1;
        strength += 1;
        dexterity += 4;
        intelligence += 1;
        setLevel(level);
        attribute.setStrength(strength);
        attribute.setDexterity(dexterity);
        attribute.setIntelligence(intelligence);
        totalAttribute.setStrength(strength);
        totalAttribute.setDexterity(dexterity);
        totalAttribute.setIntelligence(intelligence);
    }
}

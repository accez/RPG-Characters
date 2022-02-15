package com.company.Character;

import com.company.Character.CharacterClasses.HeroType;
import com.company.Character.CharacterClasses.MainPrimaryAttribute;
import com.company.Item.Item;

import java.util.HashMap;

public abstract class Character {
    private String name;
    private int level;
    private HeroType heroType;
    private MainPrimaryAttribute mainPrimaryAttribute;
    private HashMap<Slot, Item> equipment = new HashMap<>();
    public PrimaryAttribute attribute = new PrimaryAttribute();
    public TotalAttribute totalAttribute = new TotalAttribute();

    public Character(String name, HeroType heroType, MainPrimaryAttribute mainPrimaryAttribute) {
        setName(name);
        setHeroType(heroType);
        this.heroType = heroType;
        this.mainPrimaryAttribute = mainPrimaryAttribute;
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

    public HashMap<Slot, Item> getEquipment() {
        return equipment;
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public void setMainPrimaryAttribute(MainPrimaryAttribute mainPrimaryAttribute) {
        this.mainPrimaryAttribute = mainPrimaryAttribute;
    }

    public MainPrimaryAttribute getMainPrimaryAttribute() {
        return mainPrimaryAttribute;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEquipment(HashMap<Slot, Item> equipment) {
        this.equipment = equipment;
    }
}

package com.company.Character;

import com.company.Character.CharacterClasses.HeroType;
import com.company.Character.CharacterClasses.MainPrimaryAttribute;
import com.company.ErrorHandling.InvalidLevel;
import com.company.Item.Armor.Armor;
import com.company.Item.Armor.ArmorTypes;
import com.company.Item.Item;
import com.company.Item.Weapon.Weapon;
import com.company.Item.Weapon.WeaponTypes;

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

    public void equipWeapon(String name, int requiredLevel, Slot slot, WeaponTypes weaponTypes, int damage, int attackSpeed) throws InvalidLevel {
        Weapon weapon = new Weapon(name, requiredLevel, slot, weaponTypes, damage, attackSpeed);
        if (getLevel() >= weapon.getRequiredLevel()) {
            getEquipment().put(weapon.getSlot(), weapon);
            getEquipment().forEach((key, value) -> System.out.println(key + " " + value.getName()));
        } else {
            throw new InvalidLevel("Not enough level! You need to be level " + weapon.getRequiredLevel());
        }
    }

    public void equipArmor(String name, int requiredLevel, Slot slot, ArmorTypes armorTypes, int strength, int dexterity, int intelligence) throws InvalidLevel {
        Armor armor = new Armor(name, requiredLevel, slot, armorTypes);
        if (getLevel() >= armor.getRequiredLevel()) {
            armor.primaryAttribute.setStrength(strength);
            armor.primaryAttribute.setDexterity(dexterity);
            armor.primaryAttribute.setIntelligence(intelligence);
            getEquipment().put(armor.getSlot(), armor);
            getEquipment().forEach((key, value) -> System.out.println(key + " " + value.getName()));
            updateTotalAttributes(armor);
        } else {
            throw new InvalidLevel("Not enough level! You need  to be level " + armor.getRequiredLevel());

        }
    }

    public void updateTotalAttributes(Armor armor) {
        int totalStrength = armor.primaryAttribute.getStrength() + attribute.getStrength();
        int totalDexterity = armor.primaryAttribute.getDexterity() + attribute.getDexterity();
        int totalIntelligence = armor.primaryAttribute.getIntelligence() + attribute.getIntelligence();
        totalAttribute.setStrength(totalStrength);
        totalAttribute.setDexterity(totalDexterity);
        totalAttribute.setIntelligence(totalIntelligence);
    }

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

package com.company.Character;

import com.company.Character.CharacterClasses.HeroType;
import com.company.Character.CharacterClasses.MainPrimaryAttribute;
import com.company.ErrorHandling.InvalidArmor;
import com.company.ErrorHandling.InvalidLevel;
import com.company.ErrorHandling.InvalidWeapon;
import com.company.Item.Armor.Armor;
import com.company.Item.Armor.ArmorTypes;
import com.company.Item.Item;
import com.company.Item.Weapon.Weapon;
import com.company.Item.Weapon.WeaponTypes;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public abstract class Character {
    private String name;
    private int level;
    private HeroType heroType;
    private WeaponTypes weaponTypes;
    private ArmorTypes armorTypes;
    private MainPrimaryAttribute mainPrimaryAttribute;
    private HashMap<Slot,Weapon> weaponHashMap = new HashMap<>();
    private HashMap<Slot, Armor> armorHashMap = new HashMap<>();
    private HashMap<Slot, Item> equipment = new HashMap<>();
    public PrimaryAttribute attribute = new PrimaryAttribute();
    public TotalAttribute totalAttribute = new TotalAttribute();

    public Character(String name, HeroType heroType, MainPrimaryAttribute mainPrimaryAttribute) {
        setName(name);
        setHeroType(heroType);
        setMainPrimaryAttribute(mainPrimaryAttribute);
        this.level = 1;
    }

    public double calculateDpsWithWeaponAndNoArmor(MainPrimaryAttribute mainPrimaryAttribute){
        if (!getWeaponHashMap().isEmpty() && getArmorHashMap().isEmpty()) {
            return calculateDpsWithTotalAttributeOrAttribute(mainPrimaryAttribute, attribute.getStrength(), attribute.getDexterity(), attribute.getIntelligence());
        }
        return 0;
    }

    public double calculateDpsWithArmorAndNoWeapon(MainPrimaryAttribute mainPrimaryAttribute){
        if(!getArmorHashMap().isEmpty() && getWeaponHashMap().isEmpty()) {
            if (mainPrimaryAttribute == MainPrimaryAttribute.STRENGTH) {
                System.out.println(totalAttribute.getStrength());
                return (1 + totalAttribute.getStrength() / 100d);
            }
            if (mainPrimaryAttribute == MainPrimaryAttribute.DEXTERITY) {
                return (1 + totalAttribute.getDexterity() / 100d);
            }
            if (mainPrimaryAttribute == MainPrimaryAttribute.INTELLIGENCE) {
                return (1 + totalAttribute.getIntelligence() / 100d);
            }
        }
        return 0;
    }

    public double calculateDpsWithNoArmorOrWeapon(MainPrimaryAttribute mainPrimaryAttribute){
        if(getWeaponHashMap().isEmpty() && getArmorHashMap().isEmpty()){
            if (mainPrimaryAttribute == MainPrimaryAttribute.STRENGTH) {
                return (1 + attribute.getStrength() / 100d);
            }
            if (mainPrimaryAttribute == MainPrimaryAttribute.DEXTERITY) {
                return (1 + attribute.getStrength() / 100d);
            }
            if (mainPrimaryAttribute == MainPrimaryAttribute.INTELLIGENCE) {
                return (1 + attribute.getStrength() / 100d);
            }
        }
        return 0;
    }

    public double calculateDpsWithArmorAndWeapon(MainPrimaryAttribute mainPrimaryAttribute){
        if(!getArmorHashMap().isEmpty() && !getWeaponHashMap().isEmpty()) {
            return calculateDpsWithTotalAttributeOrAttribute(mainPrimaryAttribute, totalAttribute.getStrength(), totalAttribute.getDexterity(), totalAttribute.getIntelligence());
        }
        return 0;
    }

    private double calculateDpsWithTotalAttributeOrAttribute(MainPrimaryAttribute mainPrimaryAttribute, int strength, int dexterity, int intelligence) {
        if (mainPrimaryAttribute == MainPrimaryAttribute.STRENGTH) {
            return weaponHashMap.get(Slot.WEAPON).dps() * (1 + strength / 100d);
        }
        if (mainPrimaryAttribute == MainPrimaryAttribute.DEXTERITY) {
            return weaponHashMap.get(Slot.WEAPON).dps() * (1 + dexterity / 100d);
        }
        if (mainPrimaryAttribute == MainPrimaryAttribute.INTELLIGENCE) {
            return weaponHashMap.get(Slot.WEAPON).dps() * (1 + intelligence / 100d);
        }
        return 0;
    }

    public void characterDPS() {
        if (!getWeaponHashMap().isEmpty() && getArmorHashMap().isEmpty()) {
            System.out.println(calculateDpsWithWeaponAndNoArmor(getMainPrimaryAttribute()));
        }
        if(!getArmorHashMap().isEmpty() && getWeaponHashMap().isEmpty()) {
            System.out.println(calculateDpsWithArmorAndNoWeapon(getMainPrimaryAttribute()));
        }
        if(!getArmorHashMap().isEmpty() && !getWeaponHashMap().isEmpty()) {
            System.out.println(calculateDpsWithArmorAndWeapon(getMainPrimaryAttribute()));
        }
        if(getWeaponHashMap().isEmpty() && getArmorHashMap().isEmpty()){
            System.out.println(calculateDpsWithNoArmorOrWeapon(getMainPrimaryAttribute()));
        }
    }

    public abstract void levelUp();

    public boolean checkIfCharacterCanUseClothArmor(HeroType heroType)throws InvalidArmor{
        if (heroType == HeroType.MAGE) {
            setArmorTypes(ArmorTypes.CLOTH);
            return true;
        } else {
            throw new InvalidArmor("Needs to be a mage to equip that");
        }
    }

    public boolean checkIfCharacterCanUseLeatherArmor(HeroType heroType) throws InvalidArmor{
        if (heroType == HeroType.ROUGE || heroType == HeroType.RANGER) {
            setArmorTypes(ArmorTypes.LEATHER);
            return true;
        } else {
            throw new InvalidArmor("You need to be a rouge, ranger or a warrior to equip that");
        }
    }

    public boolean checkIfCharacterCanUseMailArmor(HeroType heroType) throws InvalidArmor{
        if (heroType != HeroType.MAGE) {
            setArmorTypes(ArmorTypes.MAIL);
            return true;
        } else {
            throw new InvalidArmor("You need to be a rouge, ranger or a warrior to equip that");
        }
    }

    public boolean checkIfCharacterCanUsePlateArmor(HeroType heroType) throws InvalidArmor {
        if(heroType == HeroType.WARRIOR){
            setArmorTypes(ArmorTypes.PLATE);
            return true;
        }else{
            throw new InvalidArmor("You need to be a warrior to equip that");
        }
    }

    public void checkIfHeroCanUseSword() throws InvalidWeapon {
        if (getHeroType() == HeroType.WARRIOR || getHeroType() == HeroType.ROUGE) {
            setWeaponTypes(WeaponTypes.SWORDS);
        } else {
            throw new InvalidWeapon("You need to be a warrior or a rouge to equip that");
        }
    }

    public boolean checkIfHeroCanUseWeapon(HeroType heroType, WeaponTypes weaponTypes) throws InvalidWeapon {
        String heroTypeToString = heroType.toString().toLowerCase(Locale.ROOT);
        String weaponTypeToString = weaponTypes.toString().toLowerCase(Locale.ROOT);
        if (getHeroType() == heroType) {
            setWeaponTypes(weaponTypes);
            return true;
        } else {
            throw new InvalidWeapon("You need to be a " + heroTypeToString + " in order to equip " + weaponTypeToString);
        }
    }

    public void equipWeapon(String name, int requiredLevel, Slot slot, WeaponTypes weaponTypes, int damage, int attackSpeed) throws InvalidLevel {
        Weapon weapon = new Weapon(name, requiredLevel, slot, weaponTypes, damage, attackSpeed);
        if (getLevel() >= weapon.getRequiredLevel()) {
            HashMap<Slot, Weapon> weaponHash = new HashMap<>();
            weaponHash.put(weapon.getSlot(),weapon);
            getEquipment().put(weapon.getSlot(),weapon);
            setWeaponHashMap(weaponHash);
            getEquipment().forEach((key, value) -> System.out.println(key + " " + value.getName()));
            getWeaponHashMap().forEach((key, value) -> System.out.println(key + " WeaponHash  " + value.getName()));

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
            getEquipment().put(armor.getSlot(),armor);
            getArmorHashMap().put(armor.getSlot(),armor);
            getEquipment().forEach((key, value) -> System.out.println(key + " " + value.getName()));
            updateTotalAttributes(getTotalStrengthFromArmor(),getTotalDexterityFromArmor(),getTotalIntelligenceFromArmor());
        } else {
            throw new InvalidLevel("Not enough level! You need  to be level " + armor.getRequiredLevel());
        }
    }

    public int getTotalStrengthFromArmor(){
        AtomicInteger totalStrength = new AtomicInteger();
        getArmorHashMap().forEach((key, value) -> totalStrength.addAndGet(value.primaryAttribute.getStrength()));
        return totalStrength.intValue();
    }

    public int getTotalDexterityFromArmor(){
        AtomicInteger totalDexterity = new AtomicInteger();
        getArmorHashMap().forEach((key, value) -> totalDexterity.addAndGet(value.primaryAttribute.getDexterity()));
        return totalDexterity.intValue();
    }

    public int getTotalIntelligenceFromArmor(){
        AtomicInteger totalIntelligence = new AtomicInteger();
        getArmorHashMap().forEach((key, value) -> totalIntelligence.addAndGet(value.primaryAttribute.getIntelligence()));
        return totalIntelligence.intValue();
    }

    public void updateTotalAttributes(int strength, int dexterity, int intelligence) {
        int totalStrength = strength + attribute.getStrength();
        int totalDexterity = dexterity + attribute.getDexterity();
        int totalIntelligence = intelligence + attribute.getIntelligence();
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

    public WeaponTypes getWeaponTypes() {
        return weaponTypes;
    }

    public void setWeaponTypes(WeaponTypes weaponTypes) {
        this.weaponTypes = weaponTypes;
    }

    public ArmorTypes getArmorTypes() {
        return armorTypes;
    }

    public void setArmorTypes(ArmorTypes armorTypes) {
        this.armorTypes = armorTypes;
    }

    public HashMap<Slot, Weapon> getWeaponHashMap() {
        return weaponHashMap;
    }

    public void setWeaponHashMap(HashMap<Slot, Weapon> weaponHashMap) {
        this.weaponHashMap = weaponHashMap;
    }

    public HashMap<Slot, Armor> getArmorHashMap() {
        return armorHashMap;
    }

    public void setArmorHashMap(HashMap<Slot, Armor> armorHashMap) {
        this.armorHashMap = armorHashMap;
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
}

package com.company.Game;

import com.company.Character.TotalAttribute;
import com.company.Item.Armor.Armor;
import com.company.Item.Armor.ArmorTypes;
import com.company.Character.Character;
import com.company.Character.Slot;
import com.company.Character.CharacterClasses.Mage;
import com.company.Character.CharacterClasses.Ranger;
import com.company.Character.CharacterClasses.Rouge;
import com.company.Character.CharacterClasses.Warrior;
import com.company.Item.Weapon.Weapon;
import com.company.Item.Weapon.WeaponTypes;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Game {
    GameDisplayTypes state;
    private Character character;
    private Slot slot;
    private ArmorTypes armorTypes;
    private WeaponTypes weaponTypes;

    public Game() {
        if (!createCharacter()) {
            createCharacter();
        } else {
            mainMenu();
        }
    }

    public void gameState(int input) {
        switch (input) {
            case 1 -> state = GameDisplayTypes.NAME;
            case 2 -> state = GameDisplayTypes.LEVEL;
            case 3 -> state = GameDisplayTypes.STATS;
            case 4 -> state = GameDisplayTypes.DPS;
            case 5 -> state = GameDisplayTypes.EQUIPMENT;
            case 6 -> state = GameDisplayTypes.EXIT;
        }
        switch (state) {
            case NAME:
                displayUsername();
                break;
            case LEVEL:
                levelUpOrDisplayLevel();
                break;
            case STATS:
                displayUserStats();
                break;
            case DPS:
                System.out.println("OVER 9000");
                mainMenu();
                break;
            case EQUIPMENT:
//                equipArmor();
                selectItemSlot();
                // mainMenu();
            case EXIT:
                break;
        }
    }

    public void equipArmor(String name, int requiredLevel,Slot slot, ArmorTypes armorTypes,int strength,int dexterity, int intelligence) {
        Armor armor = new Armor(name, requiredLevel, slot, armorTypes);
        armor.primaryAttribute.setStrength(strength);
        armor.primaryAttribute.setDexterity(dexterity);
        armor.primaryAttribute.setIntelligence(intelligence);
        character.getEquipment().put(armor.getSlot(), armor);
        character.getEquipment().forEach((key, value) -> System.out.println(key + " " + value.getName()));
        updateTotalAttributes(armor);
        mainMenu();
    }

    public void updateTotalAttributes(Armor armor){
        int totalStrength = armor.primaryAttribute.getStrength() + character.attribute.getStrength();
        int totalDexterity = armor.primaryAttribute.getDexterity() + character.attribute.getDexterity();
        int totalIntelligence = armor.primaryAttribute.getIntelligence() + character.attribute.getIntelligence();
        character.totalAttribute.setStrength(totalStrength);
        character.totalAttribute.setDexterity(totalDexterity);
        character.totalAttribute.setIntelligence(totalIntelligence);

        System.out.println(character.totalAttribute.getStrength());
    }
    public void equipWeapon(String name, int requiredLevel,Slot slot, WeaponTypes weaponTypes,int damage, int attackSpeed) {
        Weapon weapon = new Weapon(name,requiredLevel,slot,weaponTypes,damage,attackSpeed);
        character.getEquipment().put(weapon.getSlot(), weapon);
        character.getEquipment().forEach((key, value) -> System.out.println(key + " " + value.getName()));
        mainMenu();
    }

    public void selectItemSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select slot you want to equip (1. Head, 2. Body, 3. Legs, 4. Weapon)");
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> {
                setSlot(Slot.HEAD);
                selectArmorType();
            }
            case 2 -> {
                setSlot(Slot.BODY);
                selectArmorType();
            }
            case 3 -> {
                setSlot(Slot.LEGS);
                selectArmorType();
            }
            case 4 -> {
                setSlot(Slot.WEAPON);
                selectWeaponType();
            }
        }
    }

    public void selectWeaponType(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your weapon type(1. Axe, 2. Bow, 3. Dagger, 4. Hammer, 5. Staffs, 6. Swords, 7. Wands)");
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> {
                setWeaponTypes(WeaponTypes.AXES);
                createItem(getSlot(),armorTypes,getWeaponTypes());
            }
            case 2 -> {
                setWeaponTypes(WeaponTypes.BOWS);
                createItem(getSlot(),armorTypes,getWeaponTypes());
            }
            case 3 -> {
                setWeaponTypes(WeaponTypes.DAGGERS);
                createItem(getSlot(),armorTypes,getWeaponTypes());
            }
            case 4 -> {
                setWeaponTypes(WeaponTypes.HAMMERS);
                createItem(getSlot(),armorTypes,getWeaponTypes());
            }
            case 5 -> {
                setWeaponTypes(WeaponTypes.STAFFS);
                createItem(getSlot(),armorTypes,getWeaponTypes());
            }
            case 6 -> {
                setWeaponTypes(WeaponTypes.SWORDS);
                createItem(getSlot(),armorTypes,getWeaponTypes());
            }
            case 7 -> {
                setWeaponTypes(WeaponTypes.WANDS);
                createItem(getSlot(),armorTypes,getWeaponTypes());
            }
        }
    }

    public void selectArmorType(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your armor type(1. Cloth, 2. Leather, 3. Mail, 4. Plate)");
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> {
                setArmorTypes(ArmorTypes.CLOTH);
                createItem(getSlot(),getArmorTypes(),weaponTypes);
            }
            case 2 -> {
                setArmorTypes(ArmorTypes.LEATHER);
                createItem(getSlot(),getArmorTypes(),weaponTypes);
            }
            case 3 -> {
                setArmorTypes(ArmorTypes.MAIL);
                createItem(getSlot(),getArmorTypes(),weaponTypes);
            }
            case 4 -> {
                setArmorTypes(ArmorTypes.PLATE);
                createItem(getSlot(),getArmorTypes(),weaponTypes);
            }
        }
    }



    public void createItem(Slot slot, ArmorTypes armorType, WeaponTypes weaponTypes){
        String[] items = {"Basic", "Great", "Master"};
        ArrayList<String> createdItems = new ArrayList<>();

        if(slot == Slot.WEAPON){
            System.out.println("Select your weapon:");
            String weaponTypeName = weaponTypes.toString().toLowerCase(Locale.ROOT);
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i] + " " + weaponTypeName);
                createdItems.add(items[i] + " " + weaponTypeName);
            }
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> equipWeapon(createdItems.get(0), 1, slot, weaponTypes,2,2);
                case 2 -> equipWeapon(createdItems.get(1), 5, slot, weaponTypes,5,5);
                case 3 -> equipWeapon(createdItems.get(2), 10, slot, weaponTypes,10,10);
            }
        }else{
            System.out.println("Select your armor:");
            String armorTypeName = armorType.toString().toLowerCase(Locale.ROOT);
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i] + " " + armorTypeName);
                createdItems.add(items[i] + " " + armorTypeName);
            }
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> equipArmor(createdItems.get(0), 1, slot, armorTypes,2,2,2);
                case 2 -> equipArmor(createdItems.get(1), 5, slot, armorTypes,5,5,5);
                case 3 -> equipArmor(createdItems.get(2), 10, slot, armorTypes,10,10,10);
            }
        }
    }

    public boolean exitGame() {
        return state != GameDisplayTypes.EXIT;
    }

    public void mainMenu() {
        state = GameDisplayTypes.MENU;
        System.out.println("Write a number to select a action(1. Character name, 2. Level, 3. Stats, 4. Damage, 5. Equipment, 6. Exit Game)");
    }

    public boolean createCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your characters name:");
        String name = scanner.next();
        System.out.println("Write a number to select your class(1. Mage, 2. Ranger, 3. Rouge, 4. Warrior)");
        int chooseClass = scanner.nextInt();
        switch (chooseClass) {
            case 1 -> {
                Mage mage = new Mage(name);
                System.out.println("You created a Mage with the name " + mage.getName());
                setCharacter(mage);
                return true;
            }
            case 2 -> {
                Ranger ranger = new Ranger(name);
                System.out.println("You created a Ranger with the name " + ranger.getName());
                setCharacter(ranger);
                return true;
            }
            case 3 -> {
                Rouge rouge = new Rouge(name);
                System.out.println("You created a Rouge with the name " + rouge.getName());
                setCharacter(rouge);
                return true;
            }
            case 4 -> {
                Warrior warrior = new Warrior(name);
                System.out.println("You created a Warrior with the name " + warrior.getName());
                setCharacter(warrior);
                return true;
            }
        }
        return false;
    }

    public void displayUserStats() {
        if(character.getEquipment().isEmpty()){
            System.out.println("Strength: " + getCharacter().attribute.getStrength());
            System.out.println("Dexterity: " + getCharacter().attribute.getDexterity());
            System.out.println("Intelligence: " + getCharacter().attribute.getIntelligence());
            mainMenu();
        }else{
            System.out.println("Strength: " + getCharacter().totalAttribute.getStrength());
            System.out.println("Dexterity: " + getCharacter().totalAttribute.getDexterity());
            System.out.println("Intelligence: " + getCharacter().totalAttribute.getIntelligence());
            mainMenu();
        }
    }

    public void displayUsername() {
        System.out.println(getCharacter().getName());
        mainMenu();
    }

    public void levelUpOrDisplayLevel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Display level, 2. Level up");
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> {
                System.out.println("You are level: " + getCharacter().getLevel());
                mainMenu();
            }
            case 2 -> {
                getCharacter().levelUp();
                mainMenu();
            }
        }
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public ArmorTypes getArmorTypes() {
        return armorTypes;
    }

    public void setArmorTypes(ArmorTypes armorTypes) {
        this.armorTypes = armorTypes;
    }

    public WeaponTypes getWeaponTypes(){
        return weaponTypes;
    }

    public void setWeaponTypes(WeaponTypes weaponTypes){
        this.weaponTypes = weaponTypes;
    }
}

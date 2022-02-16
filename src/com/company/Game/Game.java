package com.company.Game;

import com.company.Character.CharacterClasses.*;
import com.company.ErrorHandling.InvalidArmor;
import com.company.ErrorHandling.InvalidLevel;
import com.company.ErrorHandling.InvalidWeapon;
import com.company.Item.Armor.ArmorTypes;
import com.company.Character.Character;
import com.company.Character.Slot;
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
                character.characterDPS();
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

    public void selectItemSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select slot you want to equip (1. Head, 2. Body, 3. Legs, 4. Weapon)");
        int input = scanner.nextInt();
        try {
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
        } catch (InvalidArmor e) {
            e.printStackTrace();
            selectItemSlot();
        }

    }

    public void selectWeaponType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your weapon type(1. Axe, 2. Bow, 3. Dagger, 4. Hammer, 5. Staffs, 6. Swords, 7. Wands)");
        int input = scanner.nextInt();
        try {
            switch (input) {
                case 1 -> {
                    character.checkIfHeroCanUseWeapon(HeroType.WARRIOR, WeaponTypes.AXES);
                    createItem(getSlot(), armorTypes, character.getWeaponTypes());
                }
                case 2 -> {
                    character.checkIfHeroCanUseWeapon(HeroType.RANGER, WeaponTypes.BOWS);
                    createItem(getSlot(), armorTypes, character.getWeaponTypes());
                }
                case 3 -> {
                    character.checkIfHeroCanUseWeapon(HeroType.ROUGE, WeaponTypes.DAGGERS);
                    createItem(getSlot(), armorTypes, character.getWeaponTypes());
                }
                case 4 -> {
                    character.checkIfHeroCanUseWeapon(HeroType.WARRIOR, WeaponTypes.HAMMERS);
                    createItem(getSlot(), armorTypes, character.getWeaponTypes());
                }
                case 5 -> {
                    character.checkIfHeroCanUseWeapon(HeroType.MAGE, WeaponTypes.STAFFS);
                    createItem(getSlot(), armorTypes, character.getWeaponTypes());
                }
                case 6 -> {
                    character.checkIfHeroCanUseSword();
                    createItem(getSlot(), armorTypes, character.getWeaponTypes());
                }
                case 7 -> {
                    character.checkIfHeroCanUseWeapon(HeroType.MAGE, WeaponTypes.WANDS);
                    createItem(getSlot(), armorTypes, character.getWeaponTypes());
                }
            }
        } catch (InvalidWeapon e) {
            e.printStackTrace();
            selectWeaponType();
        }

    }

    public void selectArmorType() throws InvalidArmor {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your armor type(1. Cloth, 2. Leather, 3. Mail, 4. Plate)");
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> {
                character.checkIfCharacterCanUseClothArmor(character.getHeroType());
                createItem(getSlot(), character.getArmorTypes(), weaponTypes);
            }
            case 2 -> {
                character.checkIfCharacterCanUseLeatherArmor(character.getHeroType());
                createItem(getSlot(), character.getArmorTypes(), weaponTypes);

            }
            case 3 -> {
                character.checkIfCharacterCanUseMailArmor(character.getHeroType());
                createItem(getSlot(), character.getArmorTypes(), weaponTypes);
            }
            case 4 -> {
                character.checkIfCharacterCanUsePlateArmor(character.getHeroType());
                createItem(getSlot(), character.getArmorTypes(), weaponTypes);
            }
        }
    }

    public void createItem(Slot slot, ArmorTypes armorType, WeaponTypes weaponType) {
        String[] items = {"Basic", "Great", "Master"};
        ArrayList<String> createdItems = new ArrayList<>();

        if (slot == Slot.WEAPON) {
            System.out.println("Select your weapon:");
            String weaponTypeName = weaponType.toString().toLowerCase(Locale.ROOT);
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i] + " " + weaponTypeName);
                createdItems.add(items[i] + " " + weaponTypeName);
            }
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            try {
                switch (input) {
                    case 1 -> {
                        character.equipWeapon(createdItems.get(0), 1, slot, weaponType, 2, 2);
                        mainMenu();
                    }
                    case 2 -> {
                        character.equipWeapon(createdItems.get(1), 5, slot, weaponType, 5, 5);
                        mainMenu();
                    }
                    case 3 -> {
                        character.equipWeapon(createdItems.get(2), 10, slot, weaponType, 10, 10);
                        mainMenu();
                    }
                }
            } catch (InvalidLevel e) {
                e.printStackTrace();
                mainMenu();
            }
        } else {
            System.out.println("Select your armor:");
            String armorTypeName = armorType.toString().toLowerCase(Locale.ROOT);
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i] + " " + armorTypeName);
                createdItems.add(items[i] + " " + armorTypeName);
            }
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            try {
                switch (input) {
                    case 1 -> {
                        character.equipArmor(createdItems.get(0), 1, slot, armorType, 2, 2, 2);
                        mainMenu();
                    }
                    case 2 -> {
                        character.equipArmor(createdItems.get(1), 5, slot, armorType, 5, 5, 5);
                        mainMenu();
                    }
                    case 3 -> {
                        character.equipArmor(createdItems.get(2), 10, slot, armorType, 10, 10, 10);
                        mainMenu();
                    }
                }
            } catch (InvalidLevel e) {
                e.printStackTrace();
                mainMenu();
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
                Mage mage = new Mage(name, HeroType.MAGE, MainPrimaryAttribute.INTELLIGENCE);
                System.out.println("You created a Mage with the name " + mage.getName());
                setCharacter(mage);
                return true;
            }
            case 2 -> {
                Ranger ranger = new Ranger(name, HeroType.RANGER, MainPrimaryAttribute.DEXTERITY);
                System.out.println("You created a Ranger with the name " + ranger.getName());
                setCharacter(ranger);
                return true;
            }
            case 3 -> {
                Rouge rouge = new Rouge(name, HeroType.ROUGE, MainPrimaryAttribute.DEXTERITY);
                System.out.println("You created a Rouge with the name " + rouge.getName());
                setCharacter(rouge);
                return true;
            }
            case 4 -> {
                Warrior warrior = new Warrior(name, HeroType.WARRIOR, MainPrimaryAttribute.STRENGTH);
                System.out.println("You created a Warrior with the name " + warrior.getName());
                setCharacter(warrior);
                return true;
            }
        }
        return false;
    }

    public void displayUserStats() {
        if (character.getArmorHashMap().isEmpty()) {
            System.out.println("Strength: " + getCharacter().attribute.getStrength());
            System.out.println("Dexterity: " + getCharacter().attribute.getDexterity());
            System.out.println("Intelligence: " + getCharacter().attribute.getIntelligence());
            mainMenu();
        } else {
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
}

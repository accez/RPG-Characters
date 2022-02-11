package com.company.Game;

import com.company.Character;
import com.company.CharacterClasses.Mage;
import com.company.CharacterClasses.Ranger;
import com.company.CharacterClasses.Rouge;
import com.company.CharacterClasses.Warrior;

import java.util.Scanner;
public class Game {
    GameDisplayTypes state;
    private Character character;

    public Game() {
        if(!createCharacter()){
            createCharacter();
        }else{
            mainMenu();
        }
    }

    public void gameState(int input) {
        switch (input) {
            case 1 -> state = GameDisplayTypes.NAME;
            case 2 -> state = GameDisplayTypes.LEVEL;
            case 3 -> state = GameDisplayTypes.STATS;
            case 4 -> state = GameDisplayTypes.DPS;
            case 5 -> state = GameDisplayTypes.EXIT;
        }
        switch (state) {
            case NAME:
                System.out.println(getCharacter().getName());
                mainMenu();
                break;
            case LEVEL:
                System.out.println("Level: 5");
                mainMenu();
                break;
            case STATS:
                System.out.println("Strength: "+getCharacter().attribute.getStrength());
                System.out.println("Dexterity: "+getCharacter().attribute.getDexterity());
                System.out.println("Intelligence: "+getCharacter().attribute.getIntelligence());
                mainMenu();
                break;
            case DPS:
                System.out.println("OVER 9000");
                mainMenu();
                break;
            case EXIT:
                break;
        }
    }

    public boolean exitGame() {
        return state != GameDisplayTypes.EXIT;
    }

    public void mainMenu() {
        state = GameDisplayTypes.MENU;
        System.out.println("Write a number to select a action(1.Character name, 2. Level, 3. Stats, 4. Damage, 5. Exit Game)");
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

    

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}

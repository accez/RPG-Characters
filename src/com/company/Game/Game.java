package com.company.Game;

public class Game {
    GameDisplayTypes state;
    public Game(){
        mainMenu();
    }
    public void gameState(int input) {
        switch (input) {
            case 1 -> state = GameDisplayTypes.MENU;
            case 2 -> state = GameDisplayTypes.NAME;
            case 3 -> state = GameDisplayTypes.LEVEL;
            case 4 -> state = GameDisplayTypes.STATS;
            case 5 -> state = GameDisplayTypes.DPS;
            case 6 -> state = GameDisplayTypes.EXIT;
        }
        switch (state){
            case NAME:
                System.out.println("Bosse");
                mainMenu();
                break;
            case LEVEL:
                System.out.println("Level: 5");
                mainMenu();
                break;
            case STATS:
                System.out.println(1);
                System.out.println(1);
                System.out.println(8);
                mainMenu();
                break;
            case DPS:
                System.out.println("OVER 9000");
                mainMenu();
                break;
            case MENU:
                mainMenu();
                break;
            case EXIT:
                break;
        }
    }
    public boolean exitGame(){
        return state != GameDisplayTypes.EXIT;
    }

    public void mainMenu(){
        state = GameDisplayTypes.MENU;
        System.out.println("Write a number to select a action(1.Character name, 2. Level, 3. Stats, 4. Damage, 5. Exit Game)");
    }
}

package com.company;

import com.company.Game.Game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        while (game.exitGame()) {
            game.gameState(scanner.nextInt());
        }
    }

}

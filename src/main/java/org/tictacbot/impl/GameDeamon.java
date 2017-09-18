package org.tictacbot.impl;


import java.util.Scanner;

public class GameDeamon {
    Scanner sc = new Scanner(System.in);
    private int choice = -1;
    private Player L1Player;
    private Player L2Player;

    public void showOptions() {
        System.out.println("Pick a Super Player: \n" +
                "\t1. Player 1\n" +
                "\t2. Player 2\n" +
                "\t3. None");
        choice = sc.nextInt();
        if (choice == 1) {
            L1Player = new SuperPlayer("cross");
            L2Player = new NormalPlayer("dot");
        } else if (choice == 2) {
            L2Player = new SuperPlayer("dot");
            L1Player = new NormalPlayer("cross");
        } else if (choice == 3) {
            L1Player = new NormalPlayer("cross");
            L2Player = new NormalPlayer("dot");
        } else {
            System.out.println("Wrong choice");
            System.exit(0);
        }
        System.out.println("\nRules: \n\n" +
                "Players:\n" +
                "\tPlayer 1 - cross\n" +
                "\tPlayer 2 - dot\n" +
                "Cells: \n" +
                "\tdot - O\n" +
                "\tcross - X\n" +
                "\tempty - E\n\n"
        );


    }

    public void start() {
        showOptions();
        Game game = new Game();
        Player currentPlayer;
        int playerId = 1;
        boolean tie = true;
        for (int steps = 0; steps < 9; steps++) {
            playerId ^= 1;
            if ((playerId + 1) == 1)
                currentPlayer = L1Player;
            else currentPlayer = L2Player;
           // System.out.println("steps: " + (steps + 1));
            if (currentPlayer.isSuper()) {
                System.out.println("Player ID: " + (playerId + 1));
                game.nextMove(currentPlayer);
                steps += 1;
            }
            if (game.isCompleted()) {
                tie = false;
                System.out.println("Game is over");
                System.out.println("winner is Player ID: " + (playerId + 1));
                return;
            }
            System.out.println("Player ID: " + (playerId + 1));
            game.nextMove(currentPlayer);
            if (game.isCompleted()) {
                tie = false;
                System.out.println("Game is over");
                System.out.println("winner is Player ID: " + (playerId + 1));
                return;
            }

        }
        if (tie) {
            System.out.println("Game is Tied");
        }

    }
}

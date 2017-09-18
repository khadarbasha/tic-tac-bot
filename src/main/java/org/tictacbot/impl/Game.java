package org.tictacbot.impl;

import org.tictacbot.design.IGame;
import org.tictacbot.models.BoardBean;
import org.tictacbot.models.CellBean;

import java.util.Scanner;


public class Game implements IGame {
    private int x_pos;
    private int y_pos;

    Scanner sc = new Scanner(System.in);


    public void prompt() {
        System.out.println("Enter x, y position: ");
        String vars[] = sc.nextLine().split(" ");

        this.x_pos = Integer.parseInt(vars[0]);
        this.y_pos = Integer.parseInt(vars[1]);
    }

    private Player currentPlayer;
    private BoardBean board = new BoardBean();

    public Game() {
    }

    @Override
    public void nextMove(Player player) {
        currentPlayer = player;
        prompt();
        if (!board.updateState(x_pos, y_pos, new CellBean(player.getDefaultState()))) {
        System.out.println("Something went wrong. Please try again.");
            nextMove(player);
        }
    }


    @Override
    public boolean isCompleted() {

        return board.rowMatch() || board.colMatch() || board.crossMatch();

    }

}

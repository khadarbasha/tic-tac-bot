package org.tictacbot.design;

import org.tictacbot.impl.Player;

public interface IGame {
    void nextMove(Player player);

    boolean isCompleted();
}

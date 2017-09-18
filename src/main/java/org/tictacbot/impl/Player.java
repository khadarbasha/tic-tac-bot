package org.tictacbot.impl;

import org.tictacbot.design.IPlayer;
import org.tictacbot.models.CState;

public abstract class Player implements IPlayer {
    private boolean superPower;

    public boolean isSuperPower() {
        return superPower;
    }

    public void setSuperPower(boolean superPower) {
        this.superPower = superPower;
    }

    private CState defaultState;
    public boolean isSuper(){
        return this.superPower;
    }
    public CState getDefaultState() {
        return defaultState;
    }

    public void setDefaultState(CState defaultState) {
        this.defaultState = defaultState;
    }

    public Player(String str) {
        if (str.equals("cross"))
            this.defaultState = CState.X;

        else
            this.defaultState = CState.O;
        this.superPower = false;

    }


    @Override
    public void move() {

    }
}

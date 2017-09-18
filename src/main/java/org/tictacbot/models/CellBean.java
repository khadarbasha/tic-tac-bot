package org.tictacbot.models;

public class CellBean {
    private int x_pos;
    private int y_pos;

    public int getX_pos() {
        return x_pos;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }
    public CellBean(CState state){
        this.state = state;
    }
    public CellBean() {
        this.state = CState.E;
    }

    private CState state;

    public CState getState() {
        return state;
    }

    public void setState(CState state) {
        this.state = state;
    }

    public boolean isEmpty() {
        return this.state == CState.E;
    }


}

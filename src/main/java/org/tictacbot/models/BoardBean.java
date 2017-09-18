package org.tictacbot.models;


public class BoardBean {
    private CellBean[][] currentState;

    public void printCurrentState() {
        int rows = 3;
        int cols = 3;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++)
                System.out.print(this.currentState[row][col].getState() + " ");
            System.out.println();
        }

    }

    private boolean validPosition(int x_pos, int y_pos) {
        return (x_pos >= 0 && x_pos < 3 && y_pos >= 0 && y_pos < 3);
    }

    public boolean updateState(int x_pos, int y_pos, CellBean cell) {
        if (!validPosition(x_pos, y_pos) || !currentState[x_pos][y_pos].isEmpty())
            return false;
        currentState[x_pos][y_pos] = cell;
        printCurrentState();
        return true;
    }

    public void init() {
        int rows = 3;
        int cols = 3;
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                currentState[row][col] = new CellBean();


    }

    public BoardBean() {
        currentState = new CellBean[3][3];
        init();
    }

    public boolean colMatch() {
        for (int col = 0; col < 3; col++) {
            if (currentState[0][col].getState() == currentState[1][col].getState() && currentState[1][col].getState() == currentState[2][col].getState() && currentState[0][col].getState() != CState.E)
                return true;
        }
        return false;
    }

    public boolean rowMatch() {
        for (int row = 0; row < 3; row++) {
            if (currentState[row][0].getState() == currentState[row][1].getState() && currentState[row][1].getState() == currentState[row][2].getState() && currentState[row][0].getState() != CState.E)
                return true;
        }
        return false;
    }

    public boolean crossMatch() {
        if (currentState[0][0].getState() == currentState[1][1].getState() &&
                currentState[1][1].getState() == currentState[2][2].getState() &&
                currentState[0][0].getState() != CState.E)
            return true;

        if (currentState[0][2].getState() == currentState[1][1].getState() &&
                currentState[1][1].getState() == currentState[2][0].getState() &&
                currentState[0][2].getState() != CState.E)
            return true;

        return false;
    }

}

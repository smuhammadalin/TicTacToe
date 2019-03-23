package sample;

public class Model {
    int[][] board = new int[3][3];
    public int moves = 0;

    public void choice(Integer field, String value) {
        Integer val = null;
        if (value == "X") {
            val = -1;
        } else if (value == "O") {
            val = 1;
        }
        board[field % 3][field / 3] = val;
        moves++;
    }

    public boolean checkBoard() {
        int diagonalL = 0, diagonalR = 0, column = 0, row = 0;

        for (int i = 0; i <= 2; i++) {
            diagonalL += board[i][i];
        }
        for (int i = 0; i <= 2; i++) {
            diagonalR += board[i][2 - i];
        }
        if (Math.abs(diagonalL) == 3 || Math.abs(diagonalR) == 3) {
            return true;
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                column += board[j][i];
                row += board[i][j];
            }
            if (Math.abs(column) == 3 || Math.abs(row) == 3) {
                return true;
            } else {
                column = 0;
                row = 0;
            }
        }
        return false;
    }
}
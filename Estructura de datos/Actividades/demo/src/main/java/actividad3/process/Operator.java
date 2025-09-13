package actividad3.process;

import java.util.*;

public class Operator {
    Random rnd = new Random();

    public int fibonacci(int n){
        //Caso base
        if (n <= 1) {
            return n;
        } else {
            //Caso recursivo
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public int[][]sudokuBoard(int num1, int num2){
        int numero1 = rnd.nextInt(3);
        int numero2 = rnd.nextInt(3);
        int numero3 = rnd.nextInt(3);
        int numero4 = rnd.nextInt(3);
        int[][] board = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };

        if (numero1 != numero2 && board[numero1][numero2] == 0){
            board[numero1][numero2] = num1;
            board[numero3][numero4] = num2;
        }
        return board;
    }

    public boolean sudokuSolver(int[][] board){
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if(isValid(board, r, c, num)) {
                            board[r][c] = num;
                            if (sudokuSolver(board)){
                                return true;
                            } else {
                                board[r][c] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return sumValid(board);
    }

    public boolean isValid(int[][] board, int r, int c, int num){
        if (exists(board, num)) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (board[r][i] == num && i != c) {
                return false;
            }
            if (board[i][c] == num && i != r) {
                return false;
            }
        }
        return true;
    }

    public boolean exists(int[][] board, int num) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean sumValid(int[][] board){
        int sumRow, sumCol, sumDiagl;
        for (int i = 0; i < 3; i++) {
            sumCol = 0;
            sumRow = 0;
            for (int j = 0; j < 3; j++) {
                sumCol += board[i][j];
                sumRow += board[j][i];
            }
            if (sumCol != 15 || sumRow != 15) {
                return false;
            }
        }

        sumDiagl = board[0][0] + board[1][1] + board[2][2];

        if (sumDiagl != 15) {
            return false;
        }
        return true;
    }
}

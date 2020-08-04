package com.interw;

import com.interw.interfaces.InputValidatorInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Board implements InputValidatorInterface {
    // 3x3 tabel
    private static final int ROWS = 4, COLS = 4;
    private static final int EMPTY = 0;
    private int freeSpaces = 9;
    public char[][] board = new char[ROWS][COLS];
    private final Cell cellCordinate = new Cell();

    // init and print game board
    public void printBoard() {
        System.out.print("   " + 1 + "   " + 2 + "   " + 3 + "  ");
        for (int i = 1; i < ROWS; i++) {
            System.out.println("\n~~~~~~~~~~~~~");
            System.out.print(i + " | ");
            for (int j = 1; j < COLS; j++) {
                System.out.print(board[i][j]);
                System.out.print(" | ");
            }
        }
        System.out.println("\n~~~~~~~~~~~~~");
    }

    // Exceptions for entered positions

    protected boolean isValidMove(String positions) {

        if (!isSpaceBetweenXandY(positions)) {
            System.err.print("Invalid input: you must enter the x and y coordinates separated by spaces / or pattern is not correct");
           return false;
        }
        getCordinatesFronUserInput(positions);
        if (cellCordinate.getY() >= 3 || cellCordinate.getY() < 0 || cellCordinate.getX() >= 3 || cellCordinate.getX() < 0) {
            System.err.print("Invalid input: those coordinates are outside the playable area");
            return false;

        }
        else if (EMPTY != (board[cellCordinate.getX()][cellCordinate.getY()])) {
            System.err.print("Invalid input: that space is already taken");
            return false;
        }
       return EMPTY == (board[cellCordinate.getX()][cellCordinate.getY()]);

    }

    // Add sign in cell
    protected boolean add(char playerSign) {
        this.freeSpaces--;

        board[cellCordinate.getX()][cellCordinate.getY()] = playerSign;
        // Check if someone won
        return isWin(playerSign);
    }

    protected boolean hasFreeSpaces() {
        return this.freeSpaces > 0;
    }

    // Chack winner
    private boolean isWin(char playerSign) {
        return areColumns() || areRows() || areDiagonals();

    }

    // Check win by rows
    private boolean areRows() {

        for (int i = 0; i < ROWS; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                return true;
            }
        }
        return false;
    }

    // Check win by columns
    private boolean areColumns() {

        for (int i = 0; i < COLS; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0) {
                return true;
            }
        }
        return false;
    }

    // Check win by diagonals
    private boolean areDiagonals() {
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
                board[0][2] == board[1][1] && board[1][1] == board[2][0]) && board[1][1] != 0;

    }


    @Override
    public void getCordinatesFronUserInput(String position) {

        // get cordinate value from string position
        String[] pomarr = position.split(" ");
        int[] arrayXandY = new int[pomarr.length];

        for (int i = 0; i < pomarr.length; i++) {
            try {
                arrayXandY[i] = Integer.parseInt(pomarr[i]);
            } catch (NumberFormatException exception) {
                exception.getStackTrace();

            }

        }
        cellCordinate.setX(arrayXandY[0]);
        cellCordinate.setY(arrayXandY[1]);

    }

    @Override
    public boolean isSpaceBetweenXandY(String position) {
        // regex for num-space-num
        Pattern p = Pattern.compile("^|[0-9] [0-9]$");
        Matcher m = p.matcher(position);
        return m.matches();
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }
}
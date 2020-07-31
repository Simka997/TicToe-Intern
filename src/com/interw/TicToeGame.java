package com.interw;

import com.interw.еxceptions.PositionNotValidException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TicToeGame {
    private Player currentPlayer;
    private Board board;

    public TicToeGame() {
    }

    public TicToeGame(Player player1, Player player2, Board board) {
        this.board = board;
        this.currentPlayer = player1;
        player1.setOpponent(player2);
        player2.setOpponent(player1);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    // The main method for game logic
    public StatusGame playGame(String move) {

        if (!board.isValidMove(move)) {
            return StatusGame.BAD_MOVE;
        }
        // turn off app
        if (move.toLowerCase().equals("resign")) {
            return StatusGame.QUIT;
        }

        //boolean isWinner = board.add(currentPlayer.getSign());
        if (board.add(currentPlayer.getSign())) {
            return StatusGame.WINNER;
        } else {
            if (!board.hasFreeSpaces())
                return StatusGame.UNSOLVED;
            else {
                this.currentPlayer = currentPlayer.getOpponent();
                return StatusGame.CORRECT_MOVE;
            }


        }
    }


    public boolean playAgain(Scanner scanner) {
        System.out.println("Do you wish to play again? (Y/N)");
        String input = scanner.nextLine();
        input = input.toUpperCase();

        if (input.equals("N") || input.equals("NO")) {
            System.out.println("Thank you for playing!!!");
            System.exit(0);
            return false;
        } else if (input.equals("Y") || input.equals("YES")) {

            return true;

        } else {
            System.out.println("Wrong");
        }
        System.exit(0);
        return false;
    }
}
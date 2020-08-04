package com.interw;

import java.util.Scanner;

public class Main {
    public static final String INPUT_MESSAGE = "The first player is X and the second one is O. \n";
    public static Scanner inputScanner = new Scanner(System.in);
    public static Player player1, player2;
    public static Board board = new Board();
    public static TicToeGame ticToeGame;
    public static boolean gameEnded = false;

    public static void main(String[] args) {
        // ask players to input their names
        createPlayers(inputScanner);

        // Start board and game
        startGame(board);

    }


    // get names from players and tell them about roles
    private static void createPlayers(Scanner inputScanner) {
        System.out.println(INPUT_MESSAGE);
        System.out.println("Player 1. enter your name: ");
        player1 = new Player(inputScanner.next(), PlayerSign.X_PLAYER_SIGN);
        System.out.println("Player 2. enter your name: ");
        player2 = new Player(inputScanner.next(), PlayerSign.O_PLAYER_SIGN);
    }

    // go to every status of game
    private static void startGame(Board board) {
        ticToeGame = new TicToeGame(player1, player2, board);
        // print board
        board.printBoard();
        System.out.println("Player with name : " + ticToeGame.getCurrentPlayer().getName() + " and sign : " + ticToeGame.getCurrentPlayer().getSign() + " plays !");
        inputScanner.nextLine();
        while (!gameEnded) {
            String move = inputScanner.nextLine();
            StatusGame gameStatus = ticToeGame.playGame(move);
            board.printBoard();
            switch (gameStatus) {
                case QUIT: {
                    System.out.println("Player : " + ticToeGame.getCurrentPlayer() + " has been defeated" + "\n Player: " + ticToeGame.getCurrentPlayer().getOpponent() + " is the WINNER");
                    gameEnded = true;
                    break;
                }
                case BAD_MOVE: {
                    System.out.println("Bad MOVE");
                    break;
                }
                case UNSOLVED: {
                    System.out.println("No one wins, bye bye");
                    gameEnded = true;
                    break;
                }
                case WINNER: {

                    System.out.println("The winner is:  " + ticToeGame.getCurrentPlayer());
                    if (!ticToeGame.playAgain(inputScanner))
                        gameEnded = true;
                    else
                        preperForRevenge();
                    break;
                }
                case CORRECT_MOVE: {
                    System.out.println("It's " + ticToeGame.getCurrentPlayer().getName() + " player's turn, and sign : " + ticToeGame.getCurrentPlayer().getSign() + "\n");
                    break;
                }

            }
        }


    }

    private static void preperForRevenge() {
        gameEnded = false;
        createPlayers(inputScanner);

        startGame(new Board());
    }


}

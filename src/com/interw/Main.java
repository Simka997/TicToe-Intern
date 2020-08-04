package com.interw;

import java.util.Scanner;

public class Main {
    public static final String INPUT_MESSAGE = "First player is X and secon one is O. \n";
    public static Scanner inputScanner = new Scanner(System.in);
    public static Player player1, player2;
    public static Board board = new Board();
    public static TicToeGame ticToeGame;
    public static boolean gameEnded = false;

    public static void main(String[] args) {
        // ask playes to input their names
        createPlayers(inputScanner);

        // Start tabel and game
        startGame(board);

    }


    // get name from player and tell them about roles
    private static void createPlayers(Scanner inputScanner) {
        System.out.println(INPUT_MESSAGE);
        System.out.println("Your name Player 1: ");
        player1 = new Player(inputScanner.next(), PlayerSign.X_PLAYER_SIGN);
        System.out.println("Your name Player 2: ");
        player2 = new Player(inputScanner.next(), PlayerSign.O_PLAYER_SIGN);
    }

    // go to every status of game
    private static void startGame(Board board) {
        ticToeGame = new TicToeGame(player1, player2, board);
        // print tabel
        board.printBoard();
        System.out.println("Player with name : " + ticToeGame.getCurrentPlayer().getName() + " and sign : " + ticToeGame.getCurrentPlayer().getSign() + " playes !");
        inputScanner.nextLine();
        while (!gameEnded) {
            String move = inputScanner.nextLine();
            StatusGame gameStatus = ticToeGame.playGame(move);
            board.printBoard();
            switch (gameStatus) {
                case QUIT: {
                    System.out.println("Pleyer : " + ticToeGame.getCurrentPlayer() + " is defeated" + "\n Player: " + ticToeGame.getCurrentPlayer().getOpponent() + " is WINNERRRRRRRRRRRR");
                    gameEnded = true;
                    break;
                }
                case BAD_MOVE: {
                    System.out.println("Bad MOVE");
                    break;
                }
                case UNSOLVED: {
                    System.out.println("No one wins bye bye");
                    gameEnded = true;
                    break;
                }
                case WINNER: {

                    System.out.println("Winner is:  " + ticToeGame.getCurrentPlayer());
                    if (!ticToeGame.playAgain(inputScanner))
                        gameEnded = true;
                    else
                        preperForRevenge();
                    break;
                }
                case CORRECT_MOVE: {
                    System.out.println("Red je na igraca: " + ticToeGame.getCurrentPlayer().getName() + " and sign : " + ticToeGame.getCurrentPlayer().getSign() + "\n");
                    break;
                }
                case INVALID_INPUT: {
                    System.out.println("Pogresan unos odaberi od 1 do 8: ");
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

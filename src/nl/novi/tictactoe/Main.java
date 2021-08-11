package nl.novi.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to tic tac toe!");

        // create a board to play on in the command line
        String[] board = new String[9];

        for (int i = 0; i < 9; i++) {
            board[i] = Integer.toString(i);
        }

        // show board on command line
        printBoard(board);

        String currentPlayer = "X";

        boolean hasWon = false;

        while (!hasWon) {
            // Let the players decide their choices on their board
            System.out.println("\n Type number from the board where you wish to put your " + currentPlayer + " symbol");
            Scanner userInput = new Scanner(System.in);
            int selectedField = userInput.nextInt();

            board[selectedField] = currentPlayer;

            // show board on command line
            printBoard(board);

            // is there a winner?
            hasWon = hasPlayerWon(board, currentPlayer);

            if (hasWon){
                System.out.println("\n Congratulations to: " + currentPlayer + ". You are the winner!");
            }

            // switch from player
            currentPlayer = switchPlayer(currentPlayer);
        }

    }


    // methode(parameter)
    //public static outputDataType methodeNaam(inputDataType inputDataTYpenaam){...code uit te voeren..}


    public static void printBoard(String[] board) {
              // show board on command line
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);
            boolean isEndOfRow = (i + 1) % 3 == 0;
            boolean lastField = i == 8;

            if (isEndOfRow == false) {
                System.out.print(" | ");
            }

            if (isEndOfRow && !lastField) {
                System.out.println("\n---------");
            }
        }
    }

    public static String switchPlayer(String currentPlayer) {
        if (currentPlayer == "X") {
            return "O";
        } else {
            return "X";
        }
    }

    public static boolean hasPlayerWon(String[] board, String currentPlayer){
        //horizontal check
        if (board[0] == currentPlayer && board[1] == currentPlayer && board[2] == currentPlayer){
            return true;
        }
        if (board[3] == currentPlayer && board[4] == currentPlayer && board[5] == currentPlayer){
            return true;
        }
        if (board[6] == currentPlayer && board[7] == currentPlayer && board[8] == currentPlayer){
            return true;
        }
        //vertical check
        if (board[0] == currentPlayer && board[3] == currentPlayer && board[6] == currentPlayer){
            return true;
        }
        if (board[1] == currentPlayer && board[4] == currentPlayer && board[7] == currentPlayer){
            return true;
        }
        if (board[2] == currentPlayer && board[5] == currentPlayer && board[8] == currentPlayer){
            return true;
        }
        //diagonal check
        if (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer){
            return true;
        }
        if (board[3] == currentPlayer && board[4] == currentPlayer && board[5] == currentPlayer){
            return true;
        }
        if (board[6] == currentPlayer && board[4] == currentPlayer && board[2] == currentPlayer){
            return true;
        }
        return false;
    }
}

package nl.novi.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to tic tac toe!");

        // create a board to play on in the command line
        Field[] board = new Field[9];

        for (int i = 0; i < 9; i++) {
            board[i] = new Field(Integer.toString(i));
        }

        // show board on command line
        printBoard(board);

        // create player object
        Player playerA = new Player("X", "X");
        Player playerB = new Player("O", "O");

        Game game = new Game(playerA, playerB);

        boolean hasWon = false;

        while (!hasWon) {
            // Let the players decide their choices on their board
            System.out.println("\n Type number from the board where you wish to put your " + game.getCurrentPlayer().getName() + " symbol");
            Scanner userInput = new Scanner(System.in);
            int selectedField = userInput.nextInt();

            String currentPlayerToken = game.getCurrentPlayer().getToken();

            board[selectedField].setToken(currentPlayerToken);

            // show board on command line
            printBoard(board);

            // is there a winner?
            hasWon = game.hasPlayerWon(board);
            game.switchPlayer();

            if (hasWon){
                game.getCurrentPlayer().setScore(+1);
            }

            if (hasWon){
                System.out.println("\n Congratulations to: " + game.getCurrentPlayer().getName() + ". You are the winner!");
                System.out.println("\n Player" + playerA.getName() + "has a score of: " + playerA.getScore());
                System.out.println("\n Player" + playerB.getName() + "has a score of: " + playerB.getScore());
            }
        }

    }
    // methode(parameter)
    //public static outputDataType methodeNaam(inputDataType inputDataTYpenaam){...code uit te voeren..}


    public static void printBoard(Field[] board) {
              // show board on command line
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i].getToken());

            boolean isEndOfRow = (i + 1) % 3 == 0;
            boolean lastField = i == 8;

            if (!isEndOfRow) {
                System.out.print(" | ");
            }

            if (isEndOfRow && !lastField) {
                System.out.println("\n---------");
            }
        }
    }
}

import java.util.Scanner;

/**
 * UC1 - Creating Empty Tic Tac Toe Board
 * UC2 - Getting user input to choose either X or O
 * UC3 - As a Player would like to see the board so I can choose the valid cells to make my move during my turn
 *     - Write a method showBoard to display the current Board
 * UC4 - Ability for user to make a move to a desired location in the board
 *     - Select the index from 1 to 9 to make the move- Ensure the index is free
 * UC5 - Ability to check for the free space before making the desired move
 *     - Extend UC 5 to Check if the free space is available for the move
 *     - In case available make the move
 * UC6 - As a User would like to to do a toss to check who plays first.
 *     - Use Random to determine Heads or Tails and assign accordingly
 *       who starts first, the computer or the user
 * UC7 - As player would expect the Tic Tac Toe App to determine after every
 *       move the winner or the tie or change the turn
 *
 * @author Krunal Lad
 * @Since 21-06-2021
 */

public class TicTacToeGame {

    static Scanner scanner = new Scanner(System.in);
    static TicTacToeGame ticTacToeGame = new TicTacToeGame();

    // main method
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game !!! :)");
        System.out.println("Please Enter Player 1 name : ");
        String player1Name = scanner.nextLine();
        System.out.println("Please Enter Player 2 name : ");
        String player2Name = scanner.nextLine();
        char[] board = new char[10];
        board = ticTacToeGame.creatingEmptyBoard(board);

        char player1Symbol = ticTacToeGame.chooseLetter(player1Name);
        char player2Symbol;
        if (player1Symbol == 'X')
            player2Symbol = 'O';
        else
            player2Symbol = 'X';

        System.out.println(player1Name + "'s Symbol is : " + player1Symbol);
        System.out.println(player2Name + "'s Symbol is : " + player2Symbol);

        for (int i = 0; i < 10; i++) {
            // to make board visible on console
            if (i != 0)
                board[i] = '_';
        }
        boolean player1Turn = ticTacToeGame.flipCoin(player1Name, player2Name);
        char playerSymbol = ' ';
        boolean flag = true;
        // checks whose turn it is and accordingly runs the loop
        do {
            // it alternates the turn of player 1 and player 2
            if (player1Turn == true) {
                System.out.println(player1Name + " is playing now");
                playerSymbol = player1Symbol;
                flag = ticTacToeGame.gamePlay(flag, playerSymbol, board);
                player1Turn = false;
            } else {
                System.out.println(player2Name + " is playing now");
                playerSymbol = player2Symbol;
                flag = ticTacToeGame.gamePlay(flag, playerSymbol, board);
                player1Turn = true;
            }

            // checks whether player 1 has won or player 2
            if (ticTacToeGame.playerHasWon(board) == player1Symbol) {
                System.out.println(player1Name + " has won the game ");
                flag = false;
            } else if (ticTacToeGame.playerHasWon(board) == player2Symbol) {
                System.out.println(player2Name + " has won the game ");
                flag = false;
            }

            // if neither player 1 then its a tie so checks board is full
            if (ticTacToeGame.boardIsFull(board)) {
                System.out.println("Its a Tie !!!");
                flag = false;
            }
        } while (flag);

    }

    private boolean gamePlay(boolean flag, char playerSymbol, char[] board) {
        // UC5 Problem - User can check position is available or not by viewing board
        System.out.println("Press 1 - To continue to play");
        System.out.println("Press 2 - To view current board");
        System.out.println("Press 3 - To quit");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                ticTacToeGame.getUserPosition(playerSymbol, board);
                break;
            case 2:
                ticTacToeGame.showBoard(board);
                flag = gamePlay(flag, playerSymbol, board);
                break;
            case 3:
                flag = false;
                break;
        }
        return flag;
    }

    // UC6 Problem - Flipping Coin to determine who will start first
    private boolean flipCoin(String player1Name, String player2Name) {
        System.out.println("Lets have a toss !!! \n" + player1Name + " Please make a call,Press 1 for Heads or 0 for Tails");
        int userCall = scanner.nextInt();
        int coinResult = (int) (Math.floor(Math.random() * 10) % 2);
        if (coinResult == userCall) {
            System.out.println("Congrats!!! You won the toss \n" + player1Name + " will Play first");
            return true;
        } else {
            System.out.println("OOPS !!! You loss the toss \n" + player2Name + " will Play first");
            return false;
        }
    }

    //UC1 Problem - creating empty tic tac toe board
    public char[] creatingEmptyBoard(char[] board) {
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                continue;
            } else {
                board[i] = ' ';
            }
        }
        System.out.println("Currently No one is Playing");
        return board;
    }

    //UC2 Problem - taking input from user to choose either X or O
    public char chooseLetter(String player1Name) {
        System.out.println(player1Name + " Please select letter either 'X' or 'O' ");
        char symbol = scanner.next().charAt(0);
        if (symbol == 'X' || symbol == 'O') {
            System.out.println("You selected the letter !!!");
        } else {
            System.out.println("Invalid Input !!!");
            symbol = chooseLetter(player1Name);
        }
        return symbol;
    }

    // UC3 Problem - Prints Tic Tac Toe board on console
    public void showBoard(char[] board) {
        System.out.println("Current Board looks like : \n");
        int i = 1;
        while (i < 10) {
            System.out.println(board[i] + " " + board[i + 1] + " " + board[i + 2]);
            i = i + 3;
        }
        System.out.println();
    }

    // UC4 Problem - ability to make move to desired position and ensures index is free
    public void getUserPosition(char playerSymbol, char[] board) {

        System.out.println("Enter the position where you want to make a move : ");
        int playerPosition = scanner.nextInt();

        if (playerPosition > 0 && playerPosition < 10) {
            if (board[playerPosition] == '_')
                board[playerPosition] = playerSymbol;
            else
                System.out.println("SORRY !!! Position is already Occupied by someone else");
        } else {
            System.out.println("Position is out of bond,Please select valid position");
        }
    }

    // UC7 Problem - Checks if any of the player has won the game
    public char playerHasWon(char[] board) {
        int i = 1;
        // checks for row
        while (i < 10) {
            if (board[i] == board[i + 1] && board[i + 1] == board[i + 2] && board[i] != '_') {
                return board[i];
            }
            i = i + 3;
        }

        // checks for column
        while (i < 10) {
            if (board[i] == board[i + 3] && board[i + 3] == board[i + 6] && board[i] != '_') {
                return board[i];
            }
        }
        // checks for diagonals
        if (board[1] == board[5] && board[5] == board[9] && board[1] != '_')
            return board[1];
        if (board[3] == board[5] && board[5] == board[7] && board[3] != '_')
            return board[3];

        //if neither is equal it returns this
        return ' ';
    }

    // Checks whether board is full or not
    public boolean boardIsFull(char[] board) {
        int i = 1;
        while (i < 10) {
            if (board[i] == '_')
                return false;
        }
        return true;
    }
}

import java.util.Scanner;

/**
 * UC1 - Creating Empty Tic Tac Toe Board
 * UC2 - Getting user input to choose either X or O
 * UC3 - As a Player would like to see the board so I can choose the valid cells to make my move during
 * my turn - Write a method showBoard to display the current Board
 * UC4 - Ability for user to make a move to a desired location in the board
 *     - Select the index from 1 to 9 to make the move- Ensure the index is free
 * UC5 - Ability to check for the free space before making the desired move
 *     - Extend UC 5 to Check if the free space is available for the move
 *     - In case available make the move
 * UC6 - As a User would like to to do a toss to check who plays first.
 *     - Use Random to determine Heads or Tails and assign accordingly
 *       who starts first, the computer or the user
 *
 * @author Krunal Lad
 * @Since 21-06-2021
 */

public class TicTacToeGame {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        System.out.println("Welcome to Tic Tac Toe Game !!! :)");
        System.out.println("Please Enter your name : ");
        String playerName = scanner.nextLine();
        ticTacToeGame.flipCoin(playerName);
        char[] board = new char[10];
        board = ticTacToeGame.creatingEmptyBoard(board);

        char playerSymbol = ticTacToeGame.chooseLetter();
        char computerSymbol;
        if (playerSymbol == 'X')
            computerSymbol = 'O';
        else
            computerSymbol = 'X';

        System.out.println(playerName + "'s Symbol is : " + playerSymbol);
        System.out.println("Computer's Symbol is : " + computerSymbol);

        for (int i = 0; i < 10; i++) {
            // to make board visible on console
            if (i != 0)
                board[i] = '_';
        }
        boolean flag = true;

        while (flag) {

            // UC5 Problem - User can check position is available or not by viewing board
            System.out.println("Press 1 - To continue to play");
            System.out.println("Press 2 - To view current board");
            System.out.println("Press 3 - To quit");
            int userChoice = scanner.nextInt();
            switch (userChoice){
                case 1 :
                    ticTacToeGame.getUserPosition(playerSymbol, board);
                    break;
                case 2:
                    ticTacToeGame.showBoard(board);
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
    }

    // UC6 Problem - Flipping Coin to determine who will start first
    private void flipCoin(String playerName) {
        System.out.println("Lets have a toss !!! \nPlease make a call,Press 1 for Heads or 0 for Tails");
        int userCall = scanner.nextInt();
        int coinResult = (int) (Math.floor(Math.random() * 10)%2);
        if(coinResult == userCall){
            System.out.println("Congrats!!! You won the toss \n"+playerName+" will Play first");
        }else {
            System.out.println("OOPS !!! You loss the toss \nComputer will Play first");
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
    public char chooseLetter() {
        System.out.println("Please select letter either 'X' or 'O' ");
        char symbol = scanner.next().charAt(0);
        if (symbol == 'X' || symbol == 'O') {
            System.out.println("You selected the letter !!!");
        } else {
            System.out.println("Invalid Input !!!");
            symbol = chooseLetter();
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

        if (playerPosition > 0 && playerPosition < 10){
            if(board[playerPosition]=='_')
                board[playerPosition] = playerSymbol;
            else
                System.out.println("SORRY !!! Position is already Occupied by someone else");
        }else{
            System.out.println("Position is out of bond,Please select valid position");
        }
    }
}

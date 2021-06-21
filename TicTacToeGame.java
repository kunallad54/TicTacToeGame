import java.util.Scanner;

/**
 * UC1 - Creating Empty Tic Tac Toe Board
 * UC2 - Getting user input to choose either X or O
 * UC3 - As a Player would like to see the board so I can choose the valid cells to make my move during
 *       my turn - Write a method showBoard to display the current Board
 *
 * @author Krunal Lad
 * @Since 21-06-2021
 */

public class TicTacToeGame {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game !!! :)");
        System.out.println("Please Enter your name : ");
        String playerName = scanner.nextLine();

        char[] board = new char[10];
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        board = ticTacToeGame.creatingEmptyBoard(board);

        char playerSymbol = ticTacToeGame.chooseLetter();
        char computerSymbol;
        if(playerSymbol == 'X')
            computerSymbol = 'O';
        else
            computerSymbol = 'X';

        System.out.println(playerName+"'s Symbol is : "+playerSymbol);
        System.out.println("Computer's Symbol is : "+computerSymbol);

        for(int i = 0; i < 10; i++){
            // to make board visible on console
            if(i != 0)
                board[i] = '_';
        }
        ticTacToeGame.showBoard(board);
    }

    //UC1 Problem - creating empty tic tac toe board
    public char[] creatingEmptyBoard(char[] board){
        for (int i = 0; i < 10; i++){
            if(i == 0){
                continue;
            }else {
                board[i] = ' ';
            }
        }
        System.out.println("Currently No one is Playing");
        return board;
    }

    //UC2 Problem - taking input from user to choose either X or O
    public char chooseLetter(){
        System.out.println("Please select letter either 'X' or 'O' ");
        char symbol = scanner.next().charAt(0);
        if(symbol == 'X' || symbol == 'O') {
            System.out.println("You selected the letter !!!");
        }else {
            System.out.println("Invalid Input !!!");
            symbol = chooseLetter();
        }
        return symbol;
    }

    // UC3 Problem - Prints Tic Tac Toe board on console
    public void showBoard(char[] board){
        System.out.println("Current Board looks like : \n");
        int i = 1;
        while(i < 10){
            System.out.println(board[i]+" "+board[i+1]+" "+board[i+2]);
            i = i+3;
        }
        System.out.println();
    }
}

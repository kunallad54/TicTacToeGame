import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * UC8 -On Computer getting its turn would like the computer to play like me
 * here computer plays same like player does
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
        System.out.println("Please Enter Your name : ");
        String playerName = scanner.nextLine();
        char[] board = new char[10];
        board = ticTacToeGame.creatingEmptyBoard(board);

        char playerSymbol = ticTacToeGame.chooseLetter(playerName);
        char computerSymbol;
        if (playerSymbol == 'X')
            computerSymbol = 'O';
        else
            computerSymbol = 'X';

        System.out.println(playerName + "'s Symbol is : " + playerSymbol);
        System.out.println("Computer's Symbol is : " + computerSymbol);

        for (int i = 1; i < 10; i++) {
            // to make board visible on console
            board[i] = '_';
        }
        boolean player1Turn = ticTacToeGame.flipCoin(playerName);

        boolean flag = true;
        // checks whose turn it is and accordingly runs the loop
        do {
            // it alternates the turn of player 1 and player 2
            if (player1Turn) {
                System.out.println(playerName + " is playing now");
                ticTacToeGame.userGamePlay(playerSymbol, board);
                player1Turn = false;
            } else {
                System.out.println("Computer is playing now");
                ticTacToeGame.computersGamePlay(computerSymbol, board);
                player1Turn = true;
            }

            // checks whether player 1 has won or player 2
            if (ticTacToeGame.playerHasWon(board) == playerSymbol) {
                System.out.println(playerName + " has won the game ");
                flag = false;
            }
            if (ticTacToeGame.playerHasWon(board) == computerSymbol) {
                System.out.println("Computer has won the game ");
                flag = false;
            }

            // if neither player 1 then its a tie so checks board is full
            if (ticTacToeGame.boardIsFull(board)) {
                System.out.println("Its a Tie !!!");
                flag = false;
            }
        } while (flag);

    }

    public void userGamePlay(char playerSymbol, char[] board) {
        // UC5 Problem - User can check position is available or not by viewing board
        ticTacToeGame.showBoard(board);
        ticTacToeGame.getUserPosition(playerSymbol, board);
        ticTacToeGame.showBoard(board);
    }

    // UC8- Problem Solved Allowing computer to play game
    private void computersGamePlay(char computerSymbol, char[] board) {
        int i = 1;
        while (i < 10) {
            int randomPosition = ThreadLocalRandom.current().nextInt(1, 10);
            if (board[randomPosition] == '_') {
                board[randomPosition] = computerSymbol;
                break;
            }
            i++;
        }
        //System.out.println("Computer has made its move !!!");
    }

    // UC6 Problem - Flipping Coin to determine who will start first
    private boolean flipCoin(String player1Name) {
        System.out.println("Lets have a toss !!! \n" + player1Name + " Please make a call,Press 1 for Heads or 0 for Tails");
        int userCall = scanner.nextInt();
        int coinResult = (int) (Math.floor(Math.random() * 10) % 2);
        if (coinResult == userCall) {
            System.out.println("Congrats!!! You won the toss \n" + player1Name + " will Play first");
            return true;
        } else {
            System.out.println("OOPS !!! You loss the toss \nComputer will Play first");
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
            else {
                System.out.println("SORRY !!! Position is already Occupied by someone else");
                getUserPosition(playerSymbol,board);
            }
        } else {
            System.out.println("Position is out of bond,Please select valid position");
            getUserPosition(playerSymbol,board);
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

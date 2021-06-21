public class TicTacToeGame {

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game !!! :)");
        char[] board = new char[10];
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        board = ticTacToeGame.creatingEmptyBoard(board);
    }
    
    //UC1 Problem
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
}

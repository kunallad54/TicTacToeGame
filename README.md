# TicTacToeGame

## USECASES :

1. As a Player would like tostart fresh by creating a tictac toe board
   - Create a TicTacToeGame class - Create method for every use case and call from main
   - Create a board of char[] of size 10 and assign empty space to each element
   - 0th index is ignored to make it user friendly
   
2. Ability to allow the player to choose a letter X or O
   - Created a method to allow player to input X or O and call from main
   - Determined Player and Computer Letter to play the game   

3. As a Player would like to see the board so I can choose the valid cells
   to make my move during my turn
   - Write a method showBoard to display the current Board

4. Ability for user to make a move to a desired location in the board
   - Select the index from 1 to 9 to make the move.
   - Ensure the index is free

5. Ability to check for the free space before making the desired move 
   - Extend UC 5 to Check if the free space is available for the move
   - In case available make the move

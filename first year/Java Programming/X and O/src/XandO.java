
/* SELF ASSESSMENT
   1. clearBoard:
Did I use the correct method definition?
Mark out of 5: 5
Comment: I did as question stated
Did I use loops to set each position to the BLANK character?
Mark out of 5: 5
Comment: I used two for loops
   2. printBoard
Did I use the correct method definition?
Mark out of 5: 5
Comment:I did as question stated
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5:5
Comment: My board looks like the one discussed
   BOARD_SIZE. canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:I did as question stated
Did I check if a specified location was BLANK?
Mark out of 5: 5
Comment: i used == ' '
   4. makeMove
Did I have the correct function definition?
Mark out of 5:5
Comment:I did as question stated
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5: 5
Comment:    i did using =
   5. isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:       I did as question stated
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5:5
Comment: i used two for loops
   6. winner
Did I have the correct function definition and returned the winning character
Mark out of 5:I did as question stated5
Comment:
Did I identify all possible horizontal, vertical and diagonal winners
Mark out of 15: 15
Comment: There is 8 possible combinations for each player
   7.main

Did I create a board of size BOARD_SIZE by BOARD_SIZE and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of BOARD_SIZE:BOARD_SIZE
Comments: i did do that
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5: 5
Comments: i used a while loop
Did I call all of the methods above?
Mark out of 5: 5
Comments: i called all
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of BOARD_SIZE: BOARD_SIZE
Comments: i did
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of BOARD_SIZE: BOARD_SIZE
Comments: i did using an if statement
Did I display the winning player piece or a draw at the end of the game?
Mark out of BOARD_SIZE: BOARD_SIZE
Comments: i did

   8. Overall
Is my code indented correctly?
Mark out of BOARD_SIZE:BOARD_SIZE
Comments: i used ctrl + i
Do my variable names and Constants (at least four of them) make sense?
Mark out of BOARD_SIZE: BOARD_SIZE
Comments: i think they do
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2:2
Comments: they do
      Total Mark out of 100 (Add all the previous marks): 100
*/




import java.util.InputMismatchException;
import java.util.Scanner;

public class XandO {

    public static final int BOARD_SIZE = 3;
    public static final char BLANK = ' ';
    public static final char X = 'X';
    public static final char O = 'O';



    public static void main(String[] args) {

        int count = 1;
        int row = 0;
        int column = 0;
        char currentPlayerPiece = 'x';
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
        char[] numberArray = {'1', '2', '3'};
        clearBoard(board);
        printBoard(board, numberArray);
        Scanner inputScanner = new Scanner(System.in);
        winner(board);
        System.out.println("Enter co-ordinates seperated by a space in the form row space column, eg. 1 1 will enter a character in the upper right corner");
        while (!isBoardFull(board) && winner(board) == ' ') {
            try {

                System.out.print(currentPlayerPiece + ", please enter your co-ordinates >> ");
                if (!inputScanner.hasNextInt())
                    System.out.println("Please type two numbers, separated by a space.");
                row = inputScanner.nextInt() - 1;
                column = inputScanner.nextInt() - 1;
                if(canMakeMove(board, row, column)) {
                    makeMove(board, currentPlayerPiece, row, column);
                    printBoard(board, numberArray);
                    if (currentPlayerPiece == X)
                        currentPlayerPiece = O;
                    else
                        currentPlayerPiece = X;
                }
                else
                    System.out.println("This space already has a character in it. Please try again.");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please use only numbers shown on the grid");
            }
        }
        if (currentPlayerPiece == X)
            currentPlayerPiece = O;
        else
            currentPlayerPiece = X;
        if (winner(board) != ' ')
            System.out.println("The winner is " + currentPlayerPiece + "!");
        else
            System.out.println("The Match is a draw!");
    }






    public static void clearBoard(char[][] board)
    {
        for(int rowCount =0; rowCount < BOARD_SIZE; rowCount++)
        {
            for(int columnCount = 0; columnCount< BOARD_SIZE; columnCount++)
            {
                board[rowCount][columnCount] = ' ';
            }
        }
    }

    public static void printBoard(char[][] board, char [] numberArray)
    {
        System.out.println("    1" + "   2" + "   3" );
        for(int rowCount =0; rowCount < BOARD_SIZE; rowCount++)
        {
            System.out.print(numberArray[rowCount] + "  ");
            for(int columnCount = 0; columnCount< BOARD_SIZE; columnCount++)
            {
                if (columnCount == 2)
                    System.out.print( " " + board [rowCount][columnCount] + " " +"\n");
                else
                    System.out.print(" " + board [rowCount][columnCount] + " " + "|");

            }
            if(rowCount < 2)
                System.out.println("   ---" + "+" + "---" + "+" + "---");
        }
    }

    public static boolean canMakeMove(char [][] board, int row, int column)
    {
        if(board[row][column] == ' ')
            return true;
        else
            return false;
    }

    public static void makeMove (char[][] board, char currentPlayerPiece , int row, int column)
    {
        board[row][column] = currentPlayerPiece;
    }

    public static boolean isBoardFull(char[][] board)
    {
        for(int rowCount =0; rowCount < BOARD_SIZE; rowCount++) {

            for (int columnCount = 0; columnCount < BOARD_SIZE; columnCount++) {

                if(board[rowCount][columnCount] == ' ')
                    return false;
            }
        }
        return true;
    }

    public static char winner(char[][] board)
    {

        if(board[0][0] == board [0][1] && board [0][1] == board[0][2])
            return board[0][0];
        else if (board[1][0] == board [1][1] && board [1][1] == board[1][2])
            return board[1][0];
        else if (board[2][0] == board [2][1] && board [2][1] == board[2][2])
            return board[2][0];
        else if (board[0][0] == board [1][0] && board [1][0] == board[2][0])
            return board[0][0];
        else if (board[0][1] == board [1][1] && board [1][1] == board[2][1])
            return board[0][1];
        else if (board[0][2] == board [1][2] && board [1][2] == board[2][2])
            return board[0][2];
        else if (board[0][0] == board [1][1] && board [1][1] == board[2][2])
            return board[0][0];
        else if (board[0][2] == board [1][1] && board [1][1] == board[2][0])
            return board [0][2];
        else
            return ' ';
    }



}
// Board.java
// Draws the board for the game.
// Last Modified: Mar 3 2014

import static java.lang.System.out;

public class Board {

    private String[][] board;
    

    public Board() {
	board = new String[4][4];
	initBoard();
    }


    public void initBoard() {
	//	  ___|___|___ 0
	//	  ___|___|___ 1
	//	     |   |    2
	//	   0   1   2

	// make board[4][4] to account for displaying row and col #
	// row 2 does not have "___"
	// col 2 does not have "|"
       
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (i == 3 && j == 3) {
		    board[i][j] = "\n";
		}
		else if (i == 3) {
		    board[i][j] = " " + j + "  ";
		}
		else if (j == 3) {
		    board[i][j] = i + "\n";
		}
		else if (i == 2 && j == 2) {
		    board[i][j] = "    ";
		}
		else if (i == 2) {
		    board[i][j] = "   |";   
		}
		else if (j == 2) {
		    board[i][j] = "___ ";
		} 
		else {
		    board[i][j] = "___|";
		}
	    }
	}
    } // setBoard

    public void displayBoard() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		out.print(board[i][j]);
	    } 
	} 
    } // displayBoard
    
} // Board
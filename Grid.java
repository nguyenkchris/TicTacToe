// Grid.java
// Draws the grid for the game.
// Last Modified: Mar 3 2014

import static java.lang.System.out;

public class Grid {

    // keeps track of every move
    private static boolean[] moves = new boolean[9]; 
    
    // keeps track of the player's moves only
    private static boolean[] playerMoves = new boolean[9];
    
    // keeps track of the computer's moves only
    private static boolean[] computerMoves = new boolean[9];
    
    // string representation of the grid for the user
    private static String[] grid = new String[9];
    
    // set of possible winning lines
    private static int[][] winSet = {
	{0,1,2}, {3,4,5}, {6,7,8}, 
	{0,3,6}, {1,4,7}, {2,5,8},
	{0,4,8}, {2,4,6}};
    
    // keeps track of how many moves have been made
    private static int roundNumber = 0;


    /**
       Initializes the grid
     */
    public Grid() {
	initGrid();
    } // constuctor


    /**
       Initializes the grid
     */
    public void initGrid() {
	//	  _0_|_1_|_2_ 
	//	  _3_|_4_|_5_ 
	//	   6 | 7 | 8  
	for (int i = 0; i < grid.length; i++) {
	    if (i == 2 || i == 5) 
		grid[i] = "___\n";
	    else if (i == 6 || i == 7) 
		grid[i] = "   |";
	    else if (i == 8) 
		grid[i] = "   \n";
	    else 
		grid[i] = "___|";
	}
    } // initGrid


    /**
       Prints the grid
     */
    public void drawGrid() {
	for (int i = 0; i < grid.length; i++) 
	    out.print(grid[i]);
    } // drawGrid


    /**
       Displays the grid with move numbers
    */
    public void displayHelp() {
	out.println("_0_|_1_|_2_\n" +
		    "_3_|_4_|_5_\n" +
		    " 6 | 7 | 8  ");
    } // displayHelp


    /**
       Increments the moveNumber by 1
    */
    public void incRoundNumber() {
	moveNumber++;
    } // incRoundNumber


    /**
       Updates the grid with either "x" or "o" at position i
     */
    public void updateGrid(String token, int i) {
	String beg = grid[i].substring(0,1);
	String end = grid[i].substring(2);
	grid[i] = beg + token + end;
    } // updateGrid


    /**
       Updates the game's boolean array (moves) at position i to true
     */
    public void updateMoves(int i) {
	moves[i] = true;
    } // updateMoves


    /**
       Updates the player's boolean array (playerMoves) at position i to true
     */
    public void updatePlayerMoves(int i) {
	playerMoves[i] = true;
    } // updatePlayerMoves


    /**
       Updates the computer's boolean array (computerMoves) at position i to true
     */
    public void updateComputerMoves(int i) {
	computerMoves[i] = true;
    } // updateComputerMoves


    /**
       @return Returns the current moveNumber
    */
    public int getRoundNumber() {
	return moveNumber;
    } // getMoveNumber


    /**
       @return Returns true if either the computer or player has moved at position i
     */
    public boolean isPlayed(int i) {
	return moves[i];
    } // getMove


    /**
       @return Returns true if player has moved at position i 
     */
    public boolean isPlayedByPlayer(int i) {
	return playerMoves[i];
    } // getPlayerMove


    /**
       @return Returns true if computer has moved at position i
    */
    public boolean isPlayedByComp(int i) {
	return computerMoves[i];
    } // getComputerMove


    /**
       @return Returns true if the game is completed
     */
    public boolean isFinished() {
	boolean isWon = false;
	for (int i = 0; i < winSet.length; i++) {
	    String mv1 = grid[winSet[i][0]].substring(1,2);
	    String mv2 = grid[winSet[i][1]].substring(1,2);
	    String mv3 = grid[winSet[i][2]].substring(1,2);
	    if ((mv1+mv2+mv3).equals("xxx") || (mv1+mv2+mv3).equals("ooo")) {
		isWon = true;
		break;
	    }
	}
	return isWon;
    } // isWon


    /**
       @return Returns true if the grid at position i is available
     */
    public boolean checkSquareAvail(int i) {
	boolean isAvail = true;
	if (moves[i])
	    isAvail = false;
	return isAvail;
    } // checkSquareAvail

} // Grid
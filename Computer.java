// Computer.java
// Artificial Intelligence of Computer
// Last Modified: Mar 3 2014
// Look up Master of Go and Sound of the Mountain by Yasunari Kawabata

import java.util.Random;

public class Computer {

    private static int[][] winSet = {
	{0,1,2}, {3,4,5}, {6,7,8}, 
	{0,3,6}, {1,4,7}, {2,5,8},
	{0,4,8}, {2,4,6}};
    private String token;
    private Random rand = new Random();
    private Grid euclid = new Grid();

    // you can think of the board as {0,1,2,3,4,5,6,7,8}
    // which corresponds to boolean[] {F,F,F,F,F,F,F,F,F}

    // possible winning lines
    // 0,1,2 [increments by 1]
    // 3,4,5 [horizontal lines]
    // 6,7,8 

    // 0,3,6 [increments by 3]
    // 1,4,7 [vertical lines]
    // 2,5,8

    // 0,4,8 [top left to bottom right] [diagonal lines]
    // 2,4,6 [top right to bottom left]
    
    // [** FIRST **] check if can win

    // [** SECOND **] check if need to prevent win
    // if 2/3 squares in a path are TRUE, 
    // then return the number that would block it
    
    // [** THIRD **] setup winning combo
    // (for now) generate random moves
    
    // {{0,1,2}, {3,4,5}, {6,7,8}, 
    //	{0,3,6}, {1,4,7}, {2,5,8},
    //  {0,4,8}, {2,4,6}}
    public int makeSmartMove() {
	int bestMove = -1; // -1 means invalid move
	bestMove = playWin();
	if (bestMove == -1) {
	    bestMove = preventWin();
	    if (bestMove == -1) {
		bestMove = setupWin();
	    }
	}
	return bestMove;
    } // makeSmartMove


    private int setupWin() {
	int bestMove = -1;
	int index;
	int roundNumber = euclid.getRoundNumber();

	System.out.println("Setting up Win");
	if (roundNumber == 1) {
	    // if player moves in center, then move in corner
	    // if player moves in corner, then move in center
	    boolean centerSquareTaken = euclid.isMovedByPlayer(4);
	    if (centerSquareTaken == true) 
		// move in corner
		while (true) {
		    index = rand.nextInt(9);
		    boolean squareTaken = euclid.isMoved(index);
		    if (bestMove % 2 == 0 && bestMove != 4 && squareTaken == false) {
			bestMove = index;
			break;
		    }
		}
	    else {
		bestMove = 4;
	    }
	}
	else if (roundNumber >= 3) {
	    // try to set up a two way win
	    while (true) {
		index = rand.nextInt(9);
		System.out.println("Index = " + index);
		if (euclid.isMoved(index) == false) {
		    bestMove = index;
		    break;
		}
	    }
	}
	System.out.println("Best Move: " + bestMove);
	return bestMove;
    } // setupWin


    private int checkWin() {
	int bestMove = -1;
	int tempMove = -1;
	System.out.println("Checking to Win");
	for (int i = 0; i < winSet.length; i++) {
	    int count = 0; // keeps track of how many times it loops
	    for (int j = 0; j < winSet[i].length; j++) {
		int index = winSet[i][j];
		// checks the computer's previous moves
		boolean squareTaken = euclid.isMovedByComp(index);
		if (squareTaken == true) 
		    count++;
		else
		    tempMove = index;
		System.out.println("j = " + j + "\tIndex: " + index + "\tCount = " + count + "\tTempMove: " + tempMove);
		// checks that the move is actually available on the board
		if (j == 2 && count == 2 && euclid.getMove(tempMove) == false) {
		    bestMove = tempMove;
		    return bestMove;
		}
	    } 
	}
	System.out.println("Best Move: " + bestMove);
	return bestMove;
    } // checkWin


    private int preventWin() {
	int bestMove = -1;
	int tempMove = -1;		
	System.out.println("Checking to Prevent Win");
	for (int i = 0; i < winSet.length; i++) {
	    int count = 0;
	    for (int j = 0; j < winSet[i].length; j++) {
		int index = winSet[i][j];

		// checks the player's previous moves
		boolean gridValue = euclid.getPlayerMove(index);
		if (gridValue == true) 
		    count++;
		else
		    tempMove = index;
		System.out.println("j = " + j + "\tIndex: " + index + "\tCount = " + count + "\tTempMove: " + tempMove);
		if (j == 2 && count == 2 && euclid.getMove(tempMove) == false) {
		    bestMove = tempMove;
		    return bestMove;
		}
	    } 
	}
	System.out.println("Best Move: " + bestMove);
	return bestMove;
    } // preventWin




} // Computer
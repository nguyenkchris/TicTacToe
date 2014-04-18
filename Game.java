// Game.java
// Driver program
// Last Modified: Mar 3 2014

import static java.lang.System.out;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

	Grid descartes = new Grid();
	Computer alpha = new Computer();
	Scanner sc = new Scanner(System.in);
	String playerToken = "x";
	String computerToken = "o";
	int position; 


	out.println();
	descartes.displayHelp();
	out.println();

	while (true) {
	    // player's turn
	    out.print("Your Move: ");
	    position = sc.nextInt();
	    descartes.incRoundNumber();
	    descartes.updatePlayerMoves(position);
	    descartes.updateMoves(position);
	    descartes.updateGrid(playerToken, position);
	    descartes.displayGrid();
	    out.println();
	    if (descartes.isFinished()) {
		out.println("Congrats! You won!");
		break;
	    }

	    // checks for tie
	    if (descartes.getRoundNumber() == 9) {
		out.println("You tied with Alpha.");
		break;
	    }
		
	    // computer's turn
	    position = alpha.makeSmartMove(); 
	    out.println("Computer's Move: " + position);
	    descartes.incRoundNumber();
	    descartes.updateGrid(computerToken, position);
	    descartes.updateComputerMoves(position);
	    descartes.updateMoves(position);
	    descartes.displayGrid();
	    out.println();
	    if (descartes.isFinished()) {
		out.println("Sorry, you lost.");
		break;
	    }
	} // while

    } // main

} // Game


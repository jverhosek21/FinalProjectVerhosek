package Pieces;
import java.util.Scanner;

import Pieces.Board;

public class Game 
{
	
	private static boolean bActive = true;
	private static boolean bGame = true;
	
	public static void main(String[] args)
	{
		Scanner scInput = new Scanner(System.in);
		do
		{
			System.out.println("During the game enter 1 to begin new game");
	    	//System.out.println("Enter 2 to customize piece and boarder color.");
	    	System.out.println("or enter 3 to exit.");
	    	int tester = scInput.nextInt();
	    	if(tester == 1)
	    	{
	    		Board chess = new Board();
	    		chess.setBoard();
	    	}
	    	
	    	else
	    	{
	    		bActive = false;
	    	}
	    	
		}while(bActive);
	}
	
}

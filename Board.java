//uses GridWorld

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
import info.gridworld.actor.Bug;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

public class Board
{

	private final static int BOARDERSTART = 0;
	private final static int BOARDEREND = 9;
	
    public static void main(String[] args)
    {
        gameOver();   
    }
    
    /**
     * Sets board up with boarder and pieces in the correct spot
     */
    public static void setBoard()
    {
    	ActorWorld world = new ActorWorld();
    	
    	for (int iX = BOARDERSTART; iX < 10; iX+=BOARDEREND)
    	{
    		for (int iY = BOARDERSTART; iY < 10; iY++)
    		{
    			world.add(new Location (iX, iY), new Rock(Color.ORANGE));	
    			world.add(new Location (iY, iX), new Rock(Color.ORANGE));	
    		}
    	}	
    	
    	boolean bWhite = false;
    	for (int iX = 2; iX < 10; iX+=5)
    	{
    		if(iX == 7)
    		{
    			bWhite = true;
    		}
    		for (int iY = 1; iY < 9; iY++)
    		{
    			world.add(new Location (iX, iY), new Pawn(bWhite));
    		}
    	}
    	
    	bWhite = true;
    	world.add(new Location (8, 1), new Rook(bWhite));
    	world.add(new Location (8, 8), new Rook(bWhite));
    	world.add(new Location (8, 2), new Knight(bWhite));
    	world.add(new Location (8, 7), new Knight(bWhite));
    	world.add(new Location (8, 3), new Bishop(bWhite));
    	world.add(new Location (8, 6), new Bishop(bWhite));
    	world.add(new Location (8, 4), new Queen(bWhite));
    	world.add(new Location (8, 5), new King(bWhite));
    	
    	bWhite = false;
    	world.add(new Location(1, 8), new Rook(bWhite));
    	world.add(new Location (1, 1), new Rook(bWhite));
    	world.add(new Location(1, 7), new Knight(bWhite));
    	world.add(new Location (1, 2), new Knight(bWhite));
    	world.add(new Location(1, 6), new Bishop(bWhite));
    	world.add(new Location (1, 3), new Bishop(bWhite));
    	world.add(new Location(1, 4), new Queen(bWhite));
    	world.add(new Location (1, 5), new King(bWhite));
    	world.show();
    }
    
    /**
     * Prompts user with menu to start new game customize or end
     */
    public static void gameOver()
    {
    	System.out.println("Enter 1 to begin the game.");
    	System.out.println("Enter 2 to customize piece and boarder color.");
    	System.out.println("Enter 3 to exit.");
        Scanner scInput = new Scanner(System.in);
        int tester = scInput.nextInt();
        if (tester == 1)
        {
        	setBoard();
        	System.out.println("Enter 2 to end the game.");
            int end = scInput.nextInt();
            if (end == 2 )
            {
            	gameOver();
            }
        }
    }
}

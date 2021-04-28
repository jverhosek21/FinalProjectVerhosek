package Pieces;
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
	private static ArrayList<Piece> whitePieces;
	private static ArrayList<Piece> blackPieces;
	
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
    	
    	boolean bWhite = false;
    	for (int iX = 1; iX < 10; iX+=5)
    	{
    		if(iX == 6)
    		{
    			bWhite = true;
    		}
    		for (int iY = 0; iY < 8; iY++)
    		{
    			world.add(new Location (iX, iY), new Pawn(bWhite));
    		}
    	}
    	
    	bWhite = true;
    	whitePieces = new ArrayList<Piece>();
    	
    	Rook rook1 = new Rook(bWhite);
    	Rook rook2 = new Rook(bWhite);
    	Knight knight1 = new Knight(bWhite);
    	Knight knight2 = new Knight(bWhite);  	
    	Bishop bishop1 = new Bishop(bWhite);
    	Bishop bishop2 = new Bishop(bWhite);
    	Queen queen = new Queen(bWhite);
    	King king = new King(bWhite);
    	
    	whitePieces.add(rook1);
    	whitePieces.add(rook2);
    	whitePieces.add(knight1);
    	whitePieces.add(knight2);
    	whitePieces.add(bishop1);
    	whitePieces.add(bishop2);
    	whitePieces.add(queen);
    	whitePieces.add(king);
    	
    	world.add(new Location (7, 0), rook1);
    	world.add(new Location (7, 7), rook2);
    	world.add(new Location (7, 1), knight1);
    	world.add(new Location (7, 6), knight2);
    	world.add(new Location (7, 2), bishop1);
    	world.add(new Location (7, 5), bishop2);
    	world.add(new Location (7, 3), queen);
    	world.add(new Location (7, 4), king);
    	
    	
    	bWhite = false;
    	blackPieces = new ArrayList<Piece>();
    	
    	Rook rook3 = new Rook(bWhite);
    	Rook rook4 = new Rook(bWhite);
    	Knight knight3 = new Knight(bWhite);
    	Knight knight4 = new Knight(bWhite);  	
    	Bishop bishop3 = new Bishop(bWhite);
    	Bishop bishop4 = new Bishop(bWhite);
    	Queen queen2 = new Queen(bWhite);
    	King king2 = new King(bWhite);
    	
    	blackPieces.add(rook3);
    	blackPieces.add(rook4);
    	blackPieces.add(knight3);
    	blackPieces.add(knight4);
    	blackPieces.add(bishop3);
    	blackPieces.add(bishop4);
    	blackPieces.add(queen2);
    	blackPieces.add(king2);
    	
    	world.add(new Location(0, 7), rook3);
    	world.add(new Location (0, 0), rook4);
    	world.add(new Location(0, 6), knight3);
    	world.add(new Location (0, 1), knight4);
    	world.add(new Location(0, 5), bishop3);
    	world.add(new Location (0, 2), bishop4);
    	world.add(new Location(0, 3), queen2);
    	world.add(new Location (0, 4), king2);
    	world.show();
    }
    
    public static void check(boolean bWhite)
    {
    	ArrayList<Location> check = new ArrayList<Location>();
    	
    	if(bWhite)
    	{
    		Location kingLoc = blackPieces.get(blackPieces.size() - 1).getLocation();
    		
    		System.out.println(kingLoc.getCol() + " " + kingLoc.getRow());
    		
    		for(int iIndex = 0; iIndex < whitePieces.size(); iIndex++)
    		{
    			check.addAll(whitePieces.get(iIndex).listValidMoves());
    		}
    		
    		for(int iCounter = 0; iCounter < check.size(); iCounter++)
    		{
    			if(check.get(iCounter).getRow() == kingLoc.getRow() && check.get(iCounter).getCol() == kingLoc.getCol())
    			{
    				System.out.println("Player 2 King is in Check");
    				iCounter = check.size();
    			}
    		}
    		
    	}
    	
    	else
    	{
    		Location kingLoc = whitePieces.get(whitePieces.size() - 1).getLocation();
    		
    		for(int iIndex = 0; iIndex < blackPieces.size(); iIndex++)
    		{
    			check.addAll(blackPieces.get(iIndex).listValidMoves());
    		}
    		
    		for(int iCounter = 0; iCounter < check.size(); iCounter++)
    		{
    			if(check.get(iCounter).getRow() == kingLoc.getRow() && check.get(iCounter).getCol() == kingLoc.getCol())
    			{
    				System.out.println("Player 1 King is in Check");
    				iCounter = check.size();
    			}
    		}
    	}
    	
    	
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

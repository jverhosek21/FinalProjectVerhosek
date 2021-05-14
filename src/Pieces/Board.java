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

	private static ArrayList<Piece> whitePieces;
	private static ArrayList<Piece> blackPieces;
	private Color player1;
	private Color player2;
	
	public Board ()
	{
		player1 = Color.WHITE;
		player2 = Color.BLACK;
	}
	
	public Board (Color cP1, Color cP2)
	{
		player1 = cP1;
		player2 = cP2;
	}
    
    /**
     * Sets board up with boarder and pieces in the correct spot
     */
    public void setBoard()
    {
    	ActorWorld world = new ActorWorld();
    	
    	boolean bWhite = true;
    	
    	for (int iCol = 0; iCol < 8; iCol++)
		{
			world.add(new Location (6, iCol), new Pawn(bWhite, player1));
		}
    	
    	whitePieces = new ArrayList<Piece>();
    	
    	Rook rook1 = new Rook(bWhite, player1);
    	Rook rook2 = new Rook(bWhite, player1);
    	Knight knight1 = new Knight(bWhite, player1);
    	Knight knight2 = new Knight(bWhite, player1);  	
    	Bishop bishop1 = new Bishop(bWhite, player1);
    	Bishop bishop2 = new Bishop(bWhite, player1);
    	Queen queen = new Queen(bWhite, player1);
    	King king = new King(bWhite, player1);
    	
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
    	
    	for (int iCol = 0; iCol < 8; iCol++)
    	{
    		world.add(new Location (1, iCol), new Pawn(bWhite, player2));
    	}
    	
    	blackPieces = new ArrayList<Piece>();
    	
    	Rook rook3 = new Rook(bWhite, player2);
    	Rook rook4 = new Rook(bWhite, player2);
    	Knight knight3 = new Knight(bWhite, player2);
    	Knight knight4 = new Knight(bWhite, player2);  	
    	Bishop bishop3 = new Bishop(bWhite, player2);
    	Bishop bishop4 = new Bishop(bWhite, player2);
    	Queen queen2 = new Queen(bWhite, player2);
    	King king2 = new King(bWhite, player2);
    	
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
    
    /**
     * Check if the opposing sides king is in check, and if so prints it to the console
     * @param bWhite signifies which side made the most current move
     */
    public static void check(boolean bWhite)
    {
    	ArrayList<Location> check = new ArrayList<Location>();
    	
    	if(bWhite)
    	{
    		Location kingLoc = blackPieces.get(blackPieces.size() - 1).getLocation();
    		
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
    
    //updated, but still not checking for instance where the checkmate can be blocked by another piece (still trying to figure this out)
    public static void checkmate(boolean bWhite)
    {
    	ArrayList<Location> posMoves = new ArrayList<Location>();
    	ArrayList<Location> kingLocs = new ArrayList<Location>();
    	
    	if(bWhite)
    	{
    		//gets location of the black king piece
    		kingLocs.add(blackPieces.get(blackPieces.size() - 1).getLocation());
    		//gets all possible move locations of the king
    		kingLocs.addAll(blackPieces.get(blackPieces.size() -1).getMoveLocations());
    		
    		//gets all valid moves of the white pieces
    		for(int iIndex = 0; iIndex < whitePieces.size(); iIndex++)
    		{
    			posMoves.addAll(whitePieces.get(iIndex).listValidMoves());
    		}
    		
    		for(int iCounter = 0; iCounter < posMoves.size(); iCounter++)
    		{
    			for(int iIndex = 0; iIndex < kingLocs.size(); iIndex++)
    			{
    				if(posMoves.get(iCounter).getRow() == kingLocs.get(iIndex).getRow() && posMoves.get(iCounter).getCol() == kingLocs.get(iIndex).getCol())
        			{
        				kingLocs.remove(iIndex);
        			}
    			}
    		}
    		
    		if(kingLocs.size() == 0)
    		{
    			System.out.println("CHECKMATE: PLAYER 1 WINS");
    		}
    			
    	}
    	
    	else
    	{
    		kingLocs.add(whitePieces.get(whitePieces.size() - 1).getLocation());
    		kingLocs.addAll(whitePieces.get(whitePieces.size() -1).getMoveLocations());
    		
    		for(int iIndex = 0; iIndex < blackPieces.size(); iIndex++)
    		{
    			posMoves.addAll(blackPieces.get(iIndex).listValidMoves());
    		}
    		
    		for(int iCounter = 0; iCounter < posMoves.size(); iCounter++)
    		{
    			for(int iIndex = 0; iIndex < kingLocs.size(); iIndex++)
    			{
    				if(posMoves.get(iCounter).getRow() == kingLocs.get(iIndex).getRow() && posMoves.get(iCounter).getCol() == kingLocs.get(iIndex).getCol())
        			{
        				kingLocs.remove(iIndex);
        			}
    			}
    		}
    		
    		if(kingLocs.size() == 0)
    		{
    			System.out.println("CHECKMATE: PLAYER 2 WINS");
    		}
    		
    	}
    }
    
}

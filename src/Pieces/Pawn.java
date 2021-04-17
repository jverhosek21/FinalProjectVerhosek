package Pieces;
import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Pawn extends Piece
{
	/**
	 * Constructor
	 * @param b calls the parent class constructor
	 */
	public Pawn(boolean b)
	{
		super(b);
	}
	
	/**
	 * Prints and returns all valid moves for the pawn piece at its given location
	 * @return
	 */
	public ArrayList<Location> listValidMoves()
	{
		info.gridworld.grid.Location current = getLocation();
		int x = current.getRow();
		int y = current.getCol();
		boolean bNorm = true;
		
		ArrayList<Location> moves = new ArrayList<Location>();
		ArrayList<Actor> pieces = getGrid().getNeighbors(current);
		
		//if the pawn is white
		if(getSide())
		{
			for(int iCounter = 0; iCounter < pieces.size(); iCounter++)
			{
				//checks if there is a piece directly in front of the pawn
				if((pieces.get(iCounter).getLocation().getCol() == y) && (pieces.get(iCounter).getLocation().getRow() == x - 1))
				{
					bNorm = false;
				}
				//checks if there if there are any pieces that could be captured by the pawn
				else if((pieces.get(iCounter).getLocation().getCol() == y + 1 || pieces.get(iCounter).getLocation().getCol() == y - 1) && pieces.get(iCounter).getLocation().getRow() == x - 1)
				{
					if((pieces.get(iCounter).getLocation().getCol() == 0) || (pieces.get(iCounter).getLocation().getRow() == 9) || (pieces.get(iCounter).getLocation().getCol() == 9) || (pieces.get(iCounter).getLocation().getRow() == 0) || (pieces.get(iCounter).getColor().equals(this.getColor())))
					{
						
					}
				
					else
					{
						moves.add(pieces.get(iCounter).getLocation());
					}
				}
			}
			if(bNorm)
			{
				Location norm = new Location(x - 1, y);
				moves.add(norm);
			}
		
			System.out.println("Valid move locations are:");
			System.out.println(moves);
		}
		
		//if the pawn is black
		else
		{
			for(int iCounter = 0; iCounter < pieces.size(); iCounter++)
			{
				//checks if there is a piece directly in front of the pawn
				if((pieces.get(iCounter).getLocation().getCol() == y) && (pieces.get(iCounter).getLocation().getRow() == x + 1))
				{
					bNorm = false;
				}
				//checks if there if there are any pieces that could be captured by the pawn
				else if((pieces.get(iCounter).getLocation().getCol() == y + 1 || pieces.get(iCounter).getLocation().getCol() == y - 1) && pieces.get(iCounter).getLocation().getRow() == x + 1)
				{
					if((pieces.get(iCounter).getLocation().getCol() == 0) || (pieces.get(iCounter).getLocation().getRow() == 9) || (pieces.get(iCounter).getLocation().getCol() == 9) || (pieces.get(iCounter).getLocation().getRow() == 0) || (pieces.get(iCounter).getColor().equals(this.getColor())))
					{
						
					}
			
					else
					{
						moves.add(pieces.get(iCounter).getLocation());
					}
				}
			}
			if(bNorm)
			{
				Location norm = new Location(x + 1, y);
				moves.add(norm);
			}
	
			System.out.println("Valid move locations are:");
			System.out.println(moves);
		}
		return moves;
	}
	
	/**
	 * Checks if the location is valid for a piece and is so moves 
	 * @param y the y coordinate
	 * @param x the x coordinate 
	 */
	public void move (int x, int y)
	{
	Location move = new Location (x, y);
		
		if(canMove(move))
		{
			moveTo(move);
		}
		
		else
		{
			System.out.println("Invalid Move");
		}
	}
		
	/**
	 * checks if the piece can move to the given location
	 * @param space the given location
	 * @return returns true if possible and false if not
	 */
	public boolean canMove(Location space)
	{
			
		Grid<Actor> gr = getGrid();
		if (gr == null)
		{
			return false;
		}
		
		if(!gr.isValid(space))
		{
			return false;
		}
		
		ArrayList<Location> moves = listValidMoves();
		for(int iCounter = 0; iCounter < moves.size(); iCounter++)
		{
			if (moves.get(iCounter).equals(space))
			{
				return true;
			}
		}
		return false;
	}
	
}
package Pieces;
import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class King extends Piece
{
	/**
	 * Constructor
	 * @param b calls the parent class constructor
	 */
	public King(boolean b)
	{
		super (b);
	}
	
	/**
	 * Prints and returns all valid moves for the king piece at its given location
	 * @return
	 */
	public ArrayList<Location> listValidMoves()
	{
		info.gridworld.grid.Location current = getLocation();
		current.getCol();
		current.getRow();
		
		ArrayList<Actor> pieces = getGrid().getNeighbors(current);
		ArrayList<Location> moves = getMoveLocations();
		
		for(int iCounter = 0; iCounter < pieces.size(); iCounter++)
		{
			if((pieces.get(iCounter).getLocation().getCol() == 0) || (pieces.get(iCounter).getLocation().getRow() == 9) || (pieces.get(iCounter).getLocation().getCol() == 9) || (pieces.get(iCounter).getLocation().getRow() == 0) || (pieces.get(iCounter).getColor().equals(this.getColor())))//get the rocks out
			{
				
			}
			
			else
			{
				moves.add(pieces.get(iCounter).getLocation());
			}
		}
		
		System.out.println("Valid move locations are:");
		System.out.println(moves);
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

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Piece extends Critter
{
	
	private boolean bWhite;
	
	/**
	 * Creates a new instance of the piece class
	 * @param bWhite parameter to set the piece color
	 */
	public Piece(boolean pbWhite)
	{
		bWhite = pbWhite;
		
		if(bWhite)
		{
			setColor(Color.WHITE);
		}
		
		else
		{
			setColor(Color.BLACK);
		}
	}
	
	public boolean getSide()
	{
		return bWhite;
	}
	
	/**
	 * Checks if the location is valid for a piece and is so moves 
	 * @param y the y coordinate
	 * @param x the x coordinate 
	 */
	public void move(int x, int y)
	{
		Location move = new Location ((x), (y)); 
		
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
		
		return true;
	}
}
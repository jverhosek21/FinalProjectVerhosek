package Pieces;
import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Knight extends Piece
{
	
	public Knight (boolean b)
	{
		super (b);
	}
	
	public ArrayList<Location> listValidMoves()
	{
		Grid<Actor> gr = getGrid();
		info.gridworld.grid.Location current = getLocation();
		int col = current.getCol();
		int row = current.getRow();
		ArrayList<Location> moves = new ArrayList<Location>();
		ArrayList<Location> validMoves = new ArrayList<Location>();
		ArrayList<Location> occupied = gr.getOccupiedLocations();
		boolean bFriendly;
		
		moves.add(new Location(row + 2, col + 1));
		moves.add(new Location(row + 1, col + 2));
		moves.add(new Location(row - 2, col + 1));
		moves.add(new Location(row - 1, col + 2));
		moves.add(new Location(row - 2, col - 1));
		moves.add(new Location(row - 1, col - 2));
		moves.add(new Location(row + 2, col - 1));
		moves.add(new Location(row + 1, col - 2));
		
		for (int iCounter = 0; iCounter < moves.size(); iCounter++)
		{
			bFriendly = false;
			if(moves.get(iCounter).getRow() < 8 && moves.get(iCounter).getRow() > 0 && moves.get(iCounter).getCol() < 8 && moves.get(iCounter).getCol() > 0)
			{
				for(int iCount = 0; iCount < occupied.size(); iCount++)
				{
					if (gr.get(occupied.get(iCount)).getColor().equals(this.getColor()))
					{
						bFriendly = true;
						iCount = occupied.size();
					}
				}
				if(bFriendly)
				{
					validMoves.add(moves.get(iCounter));
				}
			}
		}
		System.out.println("Valid move locations are:");
		System.out.println(validMoves);
		
		return validMoves;
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
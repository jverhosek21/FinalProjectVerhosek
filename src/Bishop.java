import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Bishop extends Piece
{
	/**
	 * Constructor
	 * @param b calls the parent class constructor
	 */
	public Bishop(boolean b)
	{
		super (b);
	}
	
	/**
	 * combines all possible move locations into an arrayList 
	 * @return all move locations
	 */
	public ArrayList<Location> listValidMoves()
	{
		ArrayList<Location> moves =  new ArrayList<Location>();
	
		moves.addAll(getDiagonal(true, true));
		moves.addAll(getDiagonal(true, false));
		moves.addAll(getDiagonal(false, true));
		moves.addAll(getDiagonal(false, false));
		
		System.out.println("Valid move locations are:");
		System.out.println(moves);
		
		return moves;
				
	}
	
	/**
	 * gets all the diagonal locations of the direction determined by the parameters until there is a piece in the way or the edge of the board
	 * @param bNorth
	 * @param bEast
	 * @return array list of move locations
	 */
	public ArrayList<Location> getDiagonal(boolean bNorth, boolean bEast)
	{
		Grid<Actor> gr = getGrid();
		info.gridworld.grid.Location current = getLocation();
		int col = current.getCol();
		int row = current.getRow();
		ArrayList<Location> occupied = gr.getOccupiedLocations();
		ArrayList<Location> moves = new ArrayList<Location>();
		boolean bPiece = false;
		Location newLoc;
		Location oldLoc = current;
		
		if (bNorth && bEast)
		{
			bPiece = false;
			while(!bPiece)
			{
				newLoc = new Location(row - 1, col + 1);
				for(int iCounter = 0; iCounter < occupied.size(); iCounter++)
				{
					if (newLoc.equals(occupied.get(iCounter)))
					{
						bPiece = true;
						iCounter = occupied.size();
					}	
				}
				col++;
				row--;
				if(!bPiece)
				{
					moves.add(newLoc);
				}
				
				else
				{
					ArrayList<Actor> pieces = gr.getNeighbors(oldLoc);
					for(int iCounter = 0; iCounter < pieces.size(); iCounter++)
					{
						
						if((pieces.get(iCounter).getLocation().getCol() == 0) || (pieces.get(iCounter).getLocation().getRow() == 9) || (pieces.get(iCounter).getLocation().getCol() == 9) || (pieces.get(iCounter).getLocation().getRow() == 0) || (pieces.get(iCounter).getColor().equals(this.getColor())))
						{
							
						}
						
						else if((newLoc.equals(pieces.get(iCounter).getLocation())))
						{
							moves.add(newLoc);
						}		
					}
				}
				
				oldLoc = newLoc;
			}
		}
		
		else if (bNorth)
		{
			bPiece = false;
			while(!bPiece)
			{
				newLoc = new Location(row - 1, col - 1);
				for(int iCounter = 0; iCounter < occupied.size(); iCounter++)
				{
					if (newLoc.equals(occupied.get(iCounter)))
					{
						bPiece = true;
						iCounter = occupied.size();
					}		
				}
				row--;
				col--;
				if(!bPiece)
				{
					moves.add(newLoc);
				}
				
				else
				{
					ArrayList<Actor> pieces = gr.getNeighbors(oldLoc);
					for(int iCounter = 0; iCounter < pieces.size(); iCounter++)
					{
						
						if((pieces.get(iCounter).getLocation().getCol() == 0) || (pieces.get(iCounter).getLocation().getRow() == 9) || (pieces.get(iCounter).getLocation().getCol() == 9) || (pieces.get(iCounter).getLocation().getRow() == 0) || (pieces.get(iCounter).getColor().equals(this.getColor())))
						{
							
						}
						
						else if((newLoc.equals(pieces.get(iCounter).getLocation())))
						{
							moves.add(newLoc);
						}		
					}
				}
				
				oldLoc = newLoc;
			}
		}
		else if (bEast)
		{
			bPiece = false;
			while(!bPiece)
			{
				newLoc = new Location(row + 1, col + 1);
				for(int iCounter = 0; iCounter < occupied.size(); iCounter++)
				{
					if (newLoc.equals(occupied.get(iCounter)))
					{
						bPiece = true;
						iCounter = occupied.size();
					}		
				}
				row++;
				col++;
				if(!bPiece)
				{
					moves.add(newLoc);
				}
				
				else
				{
					ArrayList<Actor> pieces = gr.getNeighbors(oldLoc);
					for(int iCounter = 0; iCounter < pieces.size(); iCounter++)
					{
						
						if((pieces.get(iCounter).getLocation().getCol() == 0) || (pieces.get(iCounter).getLocation().getRow() == 9) || (pieces.get(iCounter).getLocation().getCol() == 9) || (pieces.get(iCounter).getLocation().getRow() == 0) || (pieces.get(iCounter).getColor().equals(this.getColor())))
						{
							
						}
						
						else if((newLoc.equals(pieces.get(iCounter).getLocation())))
						{
							moves.add(newLoc);
						}		
					}
				}
				
				oldLoc = newLoc;
			}
		}
		
		else
		{
			bPiece = false;
			while(!bPiece)
			{
				newLoc = new Location(row + 1, col - 1);
				for(int iCounter = 0; iCounter < occupied.size(); iCounter++)
				{
					if (newLoc.equals(occupied.get(iCounter)))
					{
						bPiece = true;
						iCounter = occupied.size();
					}		
				}
				row++;
				col--;
				if(!bPiece)
				{
					moves.add(newLoc);
				}
				
				else
				{
					ArrayList<Actor> pieces = gr.getNeighbors(oldLoc);
					for(int iCounter = 0; iCounter < pieces.size(); iCounter++)
					{
						
						if((pieces.get(iCounter).getLocation().getCol() == 0) || (pieces.get(iCounter).getLocation().getRow() == 9) || (pieces.get(iCounter).getLocation().getCol() == 9) || (pieces.get(iCounter).getLocation().getRow() == 0) || (pieces.get(iCounter).getColor().equals(this.getColor())))
						{
							
						}
						
						else if((newLoc.equals(pieces.get(iCounter).getLocation())))
						{
							moves.add(newLoc);
						}		
					}
				}
				
				oldLoc = newLoc;
				
			}
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

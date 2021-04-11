import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Rook extends Piece
{
	/**
	 * Constructor
	 * @param b calls the parent class constructor
	 */
	public Rook(boolean b)
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
		moves.addAll(getSides(true, true));
		moves.addAll(getSides(true, false));
		moves.addAll(getSides(false, true));
		moves.addAll(getSides(false, false));
		
		System.out.println("Valid move locations are:");
		System.out.println(moves);
		
		return moves;
				
	}
	
	/**
	 * gets all of the vertical/horizontal locations of the direction determined by the parameters until there is a piece in the way or the edge of the board
	 * @param bCol
	 * @param bMax
	 * @return array list of locations
	 */
	public ArrayList<Location> getSides(boolean bCol, boolean bMax)
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
		
		if (bCol && bMax)
		{
			bPiece = false;
			while(!bPiece)
			{
				newLoc = new Location(row, col + 1);
				for(int iCounter = 0; iCounter < occupied.size(); iCounter++)
				{
					if (newLoc.equals(occupied.get(iCounter)))
					{
						bPiece = true;
						iCounter = occupied.size();
					}	
				}
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
		
		else if (bCol)
		{
			bPiece = false;
			while(!bPiece)
			{
				newLoc = new Location(row, col - 1);
				for(int iCounter = 0; iCounter < occupied.size(); iCounter++)
				{
					if (newLoc.equals(occupied.get(iCounter)))
					{
						bPiece = true;
						iCounter = occupied.size();
					}		
				}
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
		else if (bMax)
		{
			bPiece = false;
			while(!bPiece)
			{
				newLoc = new Location(row + 1, col);
				for(int iCounter = 0; iCounter < occupied.size(); iCounter++)
				{
					if (newLoc.equals(occupied.get(iCounter)))
					{
						bPiece = true;
						iCounter = occupied.size();
					}		
				}
				row++;
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
				newLoc = new Location(row - 1, col);
				for(int iCounter = 0; iCounter < occupied.size(); iCounter++)
				{
					if (newLoc.equals(occupied.get(iCounter)))
					{
						bPiece = true;
						iCounter = occupied.size();
					}		
				}
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
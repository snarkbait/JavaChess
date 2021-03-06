/*
 * Class Pawn for game Java Chess
 * 
 * 
 */
package philboyd.studge;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Pawn
 * @author /u/Philboyd_Studge
 */
public class Pawn extends Piece implements Moveable
{
    private boolean moved;
    
    public Pawn(Cell location, boolean black)
    {
        super(location, black, Pieces.PAWN);
        this.moved = false;
    }
    
    public boolean hasMoved() { return moved; }
    public void setMoved() { moved = true; }
    
    @Override
    public List<Cell> getAvailableMoves(Board board)
    {
        List<Cell> moves = new ArrayList<>();
        Cell temp = Cell.getMove(location, (black) ? Direction.SOUTH : Direction.NORTH, 1);
        if (temp != null && !board.isOccupied(temp)) moves.add(temp);
        if (!moved)
        {
            Cell temp2 = Cell.getMove(location, (black) ? Direction.SOUTH : Direction.NORTH, 2);
            if (temp2 != null && !board.isOccupied(temp2) && !board.isOccupied(temp)) moves.add(temp2);
        }
        
        if (location.getX() < 7)
        {
            temp = Cell.getMove(location, (black) ? Direction.SOUTHEAST : Direction.NORTHEAST, 1);
            if (board.isEnemy(temp, black)) moves.add(temp);       
        }
        if(location.getX() > 0)
        {
            temp = Cell.getMove(location, (black) ? Direction.SOUTHWEST : Direction.NORTHWEST, 1);
            if (board.isEnemy(temp, black)) moves.add(temp);            
        }
        return moves;
    }
}

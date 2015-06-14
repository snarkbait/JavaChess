/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philboyd.studge;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tim
 */
public class Pawn extends Piece implements Moveable
{
    private boolean moved;
    private boolean queened;
    
    public Pawn(Cell location, boolean black)
    {
        super(location, black, Pieces.PAWN);
        this.moved = false;
        this.queened = false;
    }
    
    public boolean hasMoved() { return moved; }
    public void setMoved() { moved = true; }
    public boolean isQueened() { return queened; }
    
    @Override
    public List<Cell> getAvailableMoves(Board board)
    {
        List<Cell> moves = new ArrayList<>();
        if (!moved)
        {
            Cell temp = Cell.getMove(location, (black) ? Direction.SOUTH : Direction.NORTH, 2);
            if (temp != null && !board.isOccupied(temp)) moves.add(temp);
        }
        Cell temp = Cell.getMove(location, (black) ? Direction.SOUTH : Direction.NORTH, 1);
        if (temp != null && !board.isOccupied(temp)) moves.add(temp);
        
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

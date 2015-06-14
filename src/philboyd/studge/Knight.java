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
public class Knight extends Piece implements Moveable
{
    Side side;
    
    public Knight(Cell location, boolean black, Side side)
    {
        super (location, black, Pieces.KNIGHT);
        this.side = side;               
    }
    
    public Side getSide() { return side; }
    
    @Override
    public List<Cell> getAvailableMoves(Board board)
    {
        List<Cell> moves = new ArrayList<>();
        Cell temp, temp2;
        // north east
        temp = Cell.getMove(location, Direction.NORTH, 2);
        temp2 = (temp != null) ? Cell.getMove(temp, Direction.EAST, 1) : null;
        if (temp2 != null)
        {
            if ( board.isEnemy(temp2, black) || !board.isOccupied(temp2))
            {
                moves.add(temp2);
            }           
        }
        
        // east north
        temp = Cell.getMove(location, Direction.EAST, 2);
        temp2 = (temp != null) ? Cell.getMove(temp, Direction.NORTH, 1) : null;
        if (temp2 != null)
        {
            if ( board.isEnemy(temp2, black) || !board.isOccupied(temp2))
            {
                moves.add(temp2);
            }           
        }
        
        // east south
        temp = Cell.getMove(location, Direction.EAST, 2);
        temp2 = (temp != null) ? Cell.getMove(temp, Direction.SOUTH, 1) : null;
        if (temp2 != null)
        {
            if ( board.isEnemy(temp2, black) || !board.isOccupied(temp2))
            {
                moves.add(temp2);
            }           
        }
        
        // south east
        temp = Cell.getMove(location, Direction.SOUTH, 2);
        temp2 = (temp != null) ? Cell.getMove(temp, Direction.EAST, 1) : null;
        if (temp2 != null)
        {
            if ( board.isEnemy(temp2, black) || !board.isOccupied(temp2))
            {
                moves.add(temp2);
            }           
        }
        
        // south west
        temp = Cell.getMove(location, Direction.SOUTH, 2);
        temp2 = (temp != null) ? Cell.getMove(temp, Direction.WEST, 1) : null;
        if (temp2 != null)
        {
            if ( board.isEnemy(temp2, black) || !board.isOccupied(temp2))
            {
                moves.add(temp2);
            }           
        }
        
        // west south
        temp = Cell.getMove(location, Direction.WEST, 2);
        temp2 = (temp != null) ? Cell.getMove(temp, Direction.SOUTH, 1) : null;
        if (temp2 != null)
        {
            if ( board.isEnemy(temp2, black) || !board.isOccupied(temp2))
            {
                moves.add(temp2);
            }           
        }
        
        // west north
        temp = Cell.getMove(location, Direction.WEST, 2);
        temp2 = (temp != null) ? Cell.getMove(temp, Direction.NORTH, 1) : null;
        if (temp2 != null)
        {
            if ( board.isEnemy(temp2, black) || !board.isOccupied(temp2))
            {
                moves.add(temp2);
            }           
        }
        
        // north west
        temp = Cell.getMove(location, Direction.NORTH, 2);
        temp2 = (temp != null) ? Cell.getMove(temp, Direction.WEST, 1) : null;
        if (temp2 != null)
        {
            if ( board.isEnemy(temp2, black) || !board.isOccupied(temp2))
            {
                moves.add(temp2);
            }           
        }

        return moves;
    }
}

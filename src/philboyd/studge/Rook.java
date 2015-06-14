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
public class Rook extends Piece implements Moveable
{
    private Side side;
    private boolean castled;
    
    public Rook(Cell location, boolean black, Side side)
    {
        super(location, black, Pieces.ROOK);
        this.side = side;
        this.castled = false;
    }
    
    public Side getSide() {return side; }
    public boolean hasCastled() { return castled; }
    
    @Override
    public List<Cell> getAvailableMoves(Board board)
    {
        List<Cell> moves = new ArrayList<>();
        int x = location.getX();
        int y = location.getY();
        
        // NORTH
        while (Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.NORTH, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            y -= 1;
        }
        
        y = location.getY();
        
        // sOUTH
        while (Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.SOUTH, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            y += 1;
        }
        
        y = location.getY();
        
        // East
        while (Cell.inBounds(x))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.EAST, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            x += 1;
        }
        
        x = location.getX();
        
        // west
        while (Cell.inBounds(x))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.WEST, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            x -= 1;
        }
        
        return moves;
    }
    
    @Override
    public String toString()
    {
        return ((black)? "Black " : "White ") + ((side==Side.KINGS)? "Kings's Rook" : "Queen's Rook");
    }
}

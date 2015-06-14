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
public class Bishop extends Piece implements Moveable
{
    Side side;
    
    public Bishop(Cell location, boolean black, Side side)
    {
        super(location, black, Pieces.BISHOP);
        this.side = side;
    }
    
    public Side getSide() { return side; }
    
    @Override
    public List<Cell> getAvailableMoves(Board board)
    {
        System.out.println("bishop...");
        List<Cell> moves = new ArrayList<>();
        
        int x = location.getX();
        int y = location.getY();
        
        // northeast
        while(Cell.inBounds(x) && Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.NORTHEAST, 1);
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
            y -= 1;
        }
        
        x = location.getX();
        y = location.getY();
          // Southeast
        while(Cell.inBounds(x) && Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.SOUTHEAST, 1);
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
            y += 1;
        }
        x = location.getX();
        y = location.getY();
        // soutwest
        while(Cell.inBounds(x) && Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.SOUTHWEST, 1);
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
            y += 1;
        }
        x = location.getX();
        y = location.getY();
        // northwest
        while(Cell.inBounds(x) && Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.NORTHWEST, 1);
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
            y -= 1;
        }
          
        return moves;
    }
    
    @Override
    public String toString()
    {
        return ((black)? "Black " : "White ") + ((side==Side.KINGS)? "Kings's Bishop" : "Queen's Bishop");
    }
}

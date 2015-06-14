/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philboyd.studge;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Rook
 * @author /u/Philboyd_Studge
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
        
        Direction[] dirs = Direction.values();
        
        for (int i = 0; i < dirs.length; i+= 2)
        {   
            // check moves
            while (Cell.inBounds(y) && Cell.inBounds(x))
            {
                Cell temp = Cell.getMove(new Cell(x, y), dirs[i], 1);
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
                x += dirs[i].getDX();
                y += dirs[i].getDY();
            }
            x = location.getX();
            y = location.getY();
        }

        
        return moves;
    }
    
    @Override
    public String toString()
    {
        return ((black)? "Black " : "White ") + ((side==Side.KINGS)? "Kings's Rook" : "Queen's Rook");
    }
}

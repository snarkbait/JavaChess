package philboyd.studge;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Queen
 * @author /u/Philboyd_Studge
 */
public class Queen extends Piece implements Moveable
{
    public Queen(Cell location, boolean black)
    {
        super(location, black, Pieces.QUEEN);
    }
    
    @Override
    public List<Cell> getAvailableMoves(Board board)
    {
        List<Cell> moves = new ArrayList<>();        
        int x = location.getX();
        int y = location.getY();
        
        Direction[] dirs = Direction.values();
        
        for (Direction each : dirs)
        {
            while (Cell.inBounds(x) && Cell.inBounds(y))
            {
                Cell temp = Cell.getMove(new Cell(x, y), each, 1);
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
                x += each.getDX();
                y += each.getDY();
            }

            x = location.getX();
            y = location.getY();
        }
       
        return moves;
    }
}

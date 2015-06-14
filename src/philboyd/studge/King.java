package philboyd.studge;

import java.util.ArrayList;
import java.util.List;

/**
 * Class King
 * @author /u/Philboyd_Studge
 */
class King extends Piece implements Moveable
{

    boolean inCheck;
    
    public King(Cell location, boolean black)
    {
        super(location, black, Pieces.KING);
        inCheck = false;
    }
    @Override
    public List<Cell> getAvailableMoves(Board board)
    {
        List<Cell> moves = new ArrayList<>(); 
        Direction[] dirs = Direction.values();
        for (Direction each : dirs)
        {
            Cell temp = Cell.getMove(location, each, 1);
            if (temp != null && (board.isEnemy(temp, black) || !board.isOccupied(temp)))
            {
                moves.add(temp);
            }
        
        }
        return moves;
    }   
}

package philboyd.studge;

import java.util.List;

/**
 * Interface Moveable for chess pieces
 * @author /u/Philboyd_Studge
 */
public interface Moveable
{
    public List<Cell> getAvailableMoves(Board board);
}

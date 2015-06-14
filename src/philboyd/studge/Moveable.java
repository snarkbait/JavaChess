package philboyd.studge;

import java.util.List;

/**
 *
 * @author /u/Philboyd_Studge
 */
public interface Moveable
{
    public List<Cell> getAvailableMoves(Board board);
}

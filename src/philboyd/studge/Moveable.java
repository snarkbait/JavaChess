package philboyd.studge;

import java.util.List;

/**
 *
 * @author tim
 */
public interface Moveable
{
    public List<Cell> getAvailableMoves(Board board);
}

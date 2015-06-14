package philboyd.studge;

/**
 * Enumerator for Direction on the chess board
 * Includes delta values for movement
 * @author /u/Philboyd_Studge
 */
public enum Direction {
    NORTH(0, -1), NORTHEAST(1, -1), EAST(1, 0),
    SOUTHEAST(1, 1), SOUTH(0, 1), SOUTHWEST(-1, 1),
    WEST(-1, 0), NORTHWEST(-1, -1);
    
    private final int dx, dy;
    
    private Direction(int dx, int dy)
    {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Get delta move vector for current direction
     * @return dx Delta value for x
     */    
    public int getDX()
    { 
        return dx; 
    }

    /**
     * Get delta move vector for current direction
     * @return dy delta value for y
     */
    public int getDY()
    { 
        return dy; 
    }
}

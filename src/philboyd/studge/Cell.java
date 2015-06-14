package philboyd.studge;

/**
 * Class Cell defines a 2d point, or square of the chessboard, starting
 * with 0,0 on the top left and going to 7,7 on the bottom right.
 * 
 * @author /u/Philboyd_Studge
 */
public class Cell
{
    private final int x, y;
    
    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    /**
     * 
     * @return x value of x
     */
    public int getX() { return x; }
    
    /**
     * 
     * @return y value of y
     */
    public int getY() { return y; }
    
    /**
     * Gets a player move coordinates in the given direction
     * and checks the bounds
     * @param current Cell currently occupied
     * @param dir Direction to move to
     * @param num Number of spaces to move
     * @return Cell containing the x-y coords of the move, or null if out of bounds
     */
    public static Cell getMove(Cell current, Direction dir, int num)
    {
        
        int nx = current.getX() + (dir.getDX() * num);
        int ny = current.getY() + (dir.getDY() * num);
        if ((!inBounds(nx)) || (!inBounds(ny))) return null;
        Cell temp = new Cell(nx, ny);
        return temp;
    }
    
    /**
     * Check if value is within the bounds of the chessboard
     * v >= 0 and < 8
     * @param v value to test
     * @return true if in bounds
     */
    public static boolean inBounds(int v)
    {
        return (v >=0) && (v < 8);
    }
    
    @Override
    public String toString()
    {
        return "X:" + x + " : Y:" + y;
    }
}

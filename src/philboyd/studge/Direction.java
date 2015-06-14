/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philboyd.studge;

/**
 *
 * @author tim
 */
public enum Direction {
    NORTH(0, -1), NORTHEAST(1,-1), EAST(1,0),
    SOUTHEAST(1,1), SOUTH(0,1), SOUTHWEST(-1,1),
    WEST(-1,0), NORTHWEST(-1,-1);
    
    private final int dx, dy;
    
    private Direction(int dx, int dy)
    {
        this.dx = dx;
        this.dy = dy;
    }
    
    public int getDX() { return dx; }
    public int getDY() { return dy; }
}

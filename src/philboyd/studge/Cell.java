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
public class Cell
{
    private int x, y;
    
    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    
    public void move(int nx, int ny)
    {
        this.x = nx;
        this.y = ny;
    }
    
    public static Cell getMove(Cell current, Direction dir, int num)
    {
        
        int nx = current.getX() + (dir.getDX() * num);
        int ny = current.getY() + (dir.getDY() * num);
        if ((!inBounds(nx)) || (!inBounds(ny))) return null;
        Cell temp = new Cell(nx, ny);
        return temp;
    }
    
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

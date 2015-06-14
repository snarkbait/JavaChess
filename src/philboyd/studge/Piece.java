package philboyd.studge;

import java.util.List;

/**
 * Abstract Class Piece - Parent class of Chess Pieces
 * @author /u/Philboyd_Studge
 */
public abstract class Piece implements Moveable{
    
    protected Cell location;
    protected boolean black;
    protected boolean taken;
    protected Pieces type;
    
    public Piece(Cell location, boolean black, Pieces type)
    {
        this.location = location;
        this.black = black;
        this.type = type;
        this.taken = false;
    }
    
    /**
     * 
     * @return location Cell object
     */
    public Cell getLocation()
    {
        return location;
    }
    
    public void setLocation(Cell location)
    {
        this.location = location;
    }
    
    
    public boolean isBlack() { return black; }
    public Pieces getType() { return type; }
    public boolean isTaken() { return taken; }
    public void setTaken(boolean taken) { this.taken = taken; }
    
    @Override
    public abstract List<Cell> getAvailableMoves(Board board);
    
    @Override
    public String toString()
    {
        return ((black) ? "Black " : "White ") + type;
    }
    
}

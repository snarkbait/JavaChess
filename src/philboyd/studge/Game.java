package philboyd.studge;

/**
 * Class Game - main class for Chess Game
 * @author /u/Philboyd_Studge
 */
public class Game
{
    private Board board;
    private ChessGUI gui;
    
    
    public Game()
    {
        board = new Board();
        gui = new ChessGUI(board);
    }
    
    

    
    public static void main(String[] args)
    {
        Game g = new Game();
        g.gui.setVisible(true);
        
    }
}

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

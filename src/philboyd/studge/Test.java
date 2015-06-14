/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philboyd.studge;

import java.util.List;

/**
 *
 * @author tim
 */
public class Test
{
    public static void main(String[] args)
    {
        Board b = new Board();
        System.out.println(b.toString());
        //b.putCell(new Rook(new Cell(1,1),true, Side.LEFT));
        //Moveable rook = new Rook(new Cell(3, 3), true, Side.LEFT);
        //List<Cell> moves = b.getCell(new Cell(0,6)).getAvailableMoves(b);
        //if (moves != null) moves.forEach(System.out::println);
        //b.move(new Cell(0,6), moves.get(0));
        //System.out.println(b.getPiece(new Cell(3, 1)).isBlack());
        //System.out.println(b.isEnemy(new Cell(3,1), true));
        //b.move(new Cell(1, 0), moves.get(1));
        //System.out.println(b.toString());
        //moves = b.getCell(new Cell(0,7)).getAvailableMoves(b);
        //moves.forEach(System.out::println); 
//        b.move(new Cell(0,7), moves.get(0));
//        b.move(new Cell(1,6), new Cell(1,4));
//        System.out.println(b.toString());
//        moves = b.getCell(new Cell(2,7)).getAvailableMoves(b);
//        moves.forEach(System.out::println); 
//        b.move(new Cell(2,7), moves.get(0));
//        System.out.println(b.toString());
//        moves = b.getCell(new Cell(1,6)).getAvailableMoves(b);
//        moves.forEach(System.out::println); 
        
        ChessGUI game = new ChessGUI(b);
        game.setVisible(true);
        
   }
    
    
}

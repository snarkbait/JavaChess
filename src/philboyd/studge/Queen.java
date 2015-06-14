/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philboyd.studge;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tim
 */
public class Queen extends Piece implements Moveable
{
    public Queen(Cell location, boolean black)
    {
        super(location, black, Pieces.QUEEN);
    }
    
    @Override
    public List<Cell> getAvailableMoves(Board board)
    {
        List<Cell> moves = new ArrayList<>();        
        int x = location.getX();
        int y = location.getY();
        
        // NORTH
        while (Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.NORTH, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            y -= 1;
        }
        
        y = location.getY();
        
        // sOUTH
        while (Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.SOUTH, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            y += 1;
        }
        
        y = location.getY();
        
        // East
        while (Cell.inBounds(x))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.EAST, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            x += 1;
        }
        
        x = location.getX();
        
        // west
        while (Cell.inBounds(x))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.WEST, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            x -= 1;
        }
        x = location.getX();
        y = location.getY();

        
        // northeast
        while(Cell.inBounds(x) && Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.NORTHEAST, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            x += 1;
            y -= 1;
        }
        
        x = location.getX();
        y = location.getY();
          // Southeast
        while(Cell.inBounds(x) && Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.SOUTHEAST, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            x += 1;
            y += 1;
        }
        x = location.getX();
        y = location.getY();
        // soutwest
        while(Cell.inBounds(x) && Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.SOUTHWEST, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            x -= 1;
            y += 1;
        }
        x = location.getX();
        y = location.getY();
        // northwest
        while(Cell.inBounds(x) && Cell.inBounds(y))
        {
            Cell temp = Cell.getMove(new Cell(x, y), Direction.NORTHWEST, 1);
            if (temp!=null)
            {
                if (board.isOccupied(temp))
                {
                    if (board.isEnemy(temp, black))
                    {
                        moves.add(temp);
                    }
                    break;
                }
                else
                {
                    moves.add(temp);
                }
            }
            x -= 1;
            y -= 1;
        }

        
        return moves;
    }
}

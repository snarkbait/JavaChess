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
public class Board
{
    private final Moveable[][] board;
    private final int[][] TEMPLATE = { { 2, 3, 4, 5, 6, 7, 8, 9 },
                                       { 1, 1, 1, 1, 1, 1, 1, 1 },
                                       { 0, 0, 0, 0, 0, 0, 0, 0 },
                                       { 0, 0, 0, 0, 0, 0, 0, 0 },
                                       { 0, 0, 0, 0, 0, 0, 0, 0 },
                                       { 0, 0, 0, 0, 0, 0, 0, 0 },
                                       { 1, 1, 1, 1, 1, 1, 1, 1 },
                                       { 9, 8, 7, 5, 6, 4, 3, 2 } };
    
    
    
    public Board()
    {
        board = new Moveable[8][8];
        init();
    }
    
    private void init()
    {
        boolean black = true;
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (i > 1 && black) black = false;
                if (TEMPLATE[i][j] > 0)
                {
                    Cell temp = new Cell(j,i);
                    switch (TEMPLATE[i][j])
                    {
                        
                        case 1 :
                            board[j][i] = new Pawn(temp, black);
                            break;
                        case 2 :
                            board[j][i] = new Rook(temp, black, Side.LEFT);
                            break;
                        case 3 :
                            board[j][i] = new Knight(temp, black, Side.LEFT);
                            break;
                        case 4 :
                            board[j][i] = new Bishop(temp, black, Side.LEFT);
                            break;
                        case 5 : 
                            board[j][i] = new Queen(temp, black);
                            break;
                        case 6 :
                            board[j][i] = new King(temp, black);
                            break;
                        case 7 :
                            board[j][i] = new Bishop(temp, black, Side.RIGHT);
                            break;
                        case 8 :
                            board[j][i] = new Knight(temp, black, Side.RIGHT);
                            break;
                        case 9 :
                            board[j][i] = new Rook(temp, black, Side.RIGHT);
                            break;
                            
                    }
                }
                else board[j][i] = null;
            }
        }
    }
    

    public boolean isOccupied(Cell cell)
    {
        return (board[cell.getX()][cell.getY()] != null);
    }
    
    public boolean isEnemy(Cell cell, boolean black)
    {
        return isOccupied(cell) && (getPiece(cell).isBlack()!=black);
    }
    
    
    public Piece getPiece(Cell cell)
    {
        return (Piece) board[cell.getX()][cell.getY()];
    }
    public Pieces getType(int x, int y)
    {
        return (board[x][y]==null) ? null : getPiece(new Cell(x, y)).getType();
    }
    
    public boolean getBlack(int x, int y)
    {
        return (board[x][y]==null) ? null : getPiece(new Cell(x, y)).isBlack();
    }
    
    public Moveable getCell(Cell cell)
    {
        return board[cell.getX()][cell.getY()];
    }
    
    public void putCell(Piece piece)
    {
        board[piece.getLocation().getX()][piece.getLocation().getY()] = piece;
    }
    
    public void checkQueen(Piece piece)
    {
        if ((piece.getLocation().getY()==0 && !piece.isBlack())
                || (piece.getLocation().getY()==7 && piece.isBlack()))
        {
            board[piece.getLocation().getX()][piece.getLocation().getY()]
                    = new Queen(piece.getLocation(), piece.isBlack());
        }
    }
    
    public void move(Cell oldLoc, Cell newLoc)
    {
        getPiece( oldLoc ).setLocation(newLoc);
        board[newLoc.getX()][newLoc.getY()] = getCell(oldLoc);
        board[oldLoc.getX()][oldLoc.getY()] = null;
        if (getPiece( newLoc).getType().equals(Pieces.PAWN))
        {
            Pawn p = (Pawn)getPiece( newLoc );
            if (!p.hasMoved()) p.setMoved();
            checkQueen(p);
        }
            
    }
    
    @Override
    public String toString()
    {
        String retval = "";
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                retval += (board[j][i]!=null) ? getPiece(new Cell(j, i)).getType() + " " : "null ";
            }
            retval += "\n";
        }
        return retval;
    }
    
}

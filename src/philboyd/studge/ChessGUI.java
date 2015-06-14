/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philboyd.studge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author tim
 */
public class ChessGUI extends JFrame
{
    private final Color DARK = new Color(64,96,96);
    private final Color LIGHT = new Color(206,228,228);
    private final Color HILIGHT = new Color(255,32,32);
    private final Color MOVES = new Color(255,255,175);
    private final Color ATTACK = new Color(255,255,75);
    private final int BOARD_SIZE = 8;
    private final int WINDOW_WIDTH = (BOARD_SIZE * 10) * 8;
    private final int WINDOW_HEIGHT = ((BOARD_SIZE * 10) * 8) + (BOARD_SIZE * 10);
    
    private final ImageIcon PAWN_BLACK; 
    private final ImageIcon ROOK_BLACK; 
    private final ImageIcon KNIGHT_BLACK; 
    private final ImageIcon BISHOP_BLACK; 
    private final ImageIcon QUEEN_BLACK; 
    private final ImageIcon KING_BLACK; 
    private final ImageIcon PAWN_WHITE; 
    private final ImageIcon ROOK_WHITE;
    private final ImageIcon KNIGHT_WHITE;
    private final ImageIcon BISHOP_WHITE; 
    private final ImageIcon QUEEN_WHITE; 
    private final ImageIcon KING_WHITE; 

    private final Board gameboard;
    // menu bar
    JMenuBar menu;
    JMenu gameMenu;
    JMenuItem newGame, drawGame, quitGame;

    private JPanel board;
    private final GridLayout grid = new GridLayout(BOARD_SIZE,BOARD_SIZE, 1, 1);
    private final JPanel[][] cells = new JPanel[BOARD_SIZE][BOARD_SIZE];
    private final JLabel[][] labels = new JLabel[BOARD_SIZE][BOARD_SIZE];
    private JScrollPane console;
    private JTextArea text;

    private boolean selected = false;
    private int selectedX;
    private int selectedY; 
    private boolean whiteTurn;
    
    private Piece picked;
    private Piece enemy;
    
    public ChessGUI(Board gameboard)
    {
        super("Chess");
        this.whiteTurn = false;
        this.gameboard = gameboard;
        super.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        PAWN_BLACK = new ImageIcon(getClass().getResource("/philboyd/studge/resource/pawn_black.png"));
        ROOK_BLACK = new ImageIcon(getClass().getResource("/philboyd/studge/resource/rook_black.png"));
        KNIGHT_BLACK = new ImageIcon(getClass().getResource("/philboyd/studge/resource/knight_black.png"));
        BISHOP_BLACK = new ImageIcon(getClass().getResource("/philboyd/studge/resource/bishop_black.png"));
        QUEEN_BLACK = new ImageIcon(getClass().getResource("/philboyd/studge/resource/queen_black.png"));
        KING_BLACK = new ImageIcon(getClass().getResource("/philboyd/studge/resource/king_black.png"));
        PAWN_WHITE = new ImageIcon(getClass().getResource("/philboyd/studge/resource/pawn_white.png"));
        ROOK_WHITE = new ImageIcon(getClass().getResource("/philboyd/studge/resource/rook_white.png"));
        KNIGHT_WHITE = new ImageIcon(getClass().getResource("/philboyd/studge/resource/knight_white.png"));
        BISHOP_WHITE = new ImageIcon(getClass().getResource("/philboyd/studge/resource/bishop_white.png"));
        QUEEN_WHITE = new ImageIcon(getClass().getResource("/philboyd/studge/resource/queen_white.png"));
        KING_WHITE = new ImageIcon(getClass().getResource("/philboyd/studge/resource/king_white.png"));
        
        initComponents();
        refresh();
        turn();
    }
    
    private void initComponents()
    {

            //initMenu();

            board = new JPanel();
            board.setBackground(Color.BLACK);
            board.setLayout(grid);

            for (int y = 0; y < BOARD_SIZE; y++)
            {
                    for (int x = 0; x < BOARD_SIZE; x ++)
                    {
                            cells[x][y] = new JPanel();
                            cells[x][y].addMouseListener(createMouseListener(x, y));
                            labels[x][y] = new JLabel();
                            if (x % 2 != y % 2)
                            {
                                    cells[x][y].setBackground(DARK);
                            }
                            else cells[x][y].setBackground(LIGHT);
                            cells[x][y].add(labels[x][y]);
                            board.add(cells[x][y]);
                    }
            }

            text = new JTextArea();

                    // make text area automatically scroll
                    DefaultCaret caret = (DefaultCaret)text.getCaret();
                    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

                    text.setFont(new Font("Tahoma", 1, 12));
                    text.setEditable(false);
                    text.setText("Welcome to CHESS!!!\n");

            console = new JScrollPane(text);
                    console.setPreferredSize(new Dimension(WINDOW_WIDTH - 20,BOARD_SIZE * 10));
                    console.setViewportView(text);
                    console.setAutoscrolls(true);

            this.add(board, BorderLayout.CENTER);
            this.add(console, BorderLayout.PAGE_END);

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void addLabelMouselistener(MouseAdapter listener, int x, int y)
    {
        cells[x][y].addMouseListener(listener);
    }
    
    private void refresh()
    {
        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 8; x ++)
            {
                if (x % 2 != y % 2)
                {
                    cells[x][y].setBackground(DARK);
                }
                else cells[x][y].setBackground(LIGHT);
            
                if (gameboard.getType(x,y)!=null)
                {
                
                    switch (gameboard.getType(x, y))
                    {
                        case PAWN :
                            labels[x][y].setIcon((gameboard.getBlack(x, y) 
                                                    ? PAWN_BLACK : PAWN_WHITE));
                            break;
                        case ROOK :
                            labels[x][y].setIcon((gameboard.getBlack(x, y) 
                                                    ? ROOK_BLACK : ROOK_WHITE));
                            break;
                        case KNIGHT :
                            labels[x][y].setIcon((gameboard.getBlack(x, y) 
                                                    ? KNIGHT_BLACK : KNIGHT_WHITE));
                            break;
                        case BISHOP : 
                            labels[x][y].setIcon((gameboard.getBlack(x, y) 
                                                    ? BISHOP_BLACK : BISHOP_WHITE));
                            break;
                        case QUEEN :
                            labels[x][y].setIcon((gameboard.getBlack(x, y) 
                                                    ? QUEEN_BLACK : QUEEN_WHITE));
                            break;
                        case KING : 
                            labels[x][y].setIcon((gameboard.getBlack(x, y) 
                                                    ? KING_BLACK : KING_WHITE));
                            break;
                    }
                }
                else labels[x][y].setIcon(null);
            }
        }

    }  
    
    public void setSelected(boolean selected)
    {
        this.selected = selected;
    }
    public MouseAdapter createMouseListener(final int x, final int y)
    {
        return new MouseAdapter()
        {
            @Override
            public void mouseReleased(MouseEvent evt)
            {
                if (evt.getButton()==MouseEvent.BUTTON1)
                    cellClicked(x, y);
                if (evt.getButton()==MouseEvent.BUTTON3)
                {
                    selected = false;
                    refresh();
                }
            }
        };
    }

    public void cellClicked(int x, int y)
    {
        Moveable m = null;
            
        if (!selected)
        {
            cells[x][y].setBackground(HILIGHT);
            selected = true;
            selectedX = x;
            selectedY = y;
            if (gameboard.getType(x, y) != null && gameboard.getBlack(x, y)!=whiteTurn)
            {
                picked = gameboard.getPiece(new Cell(selectedX,selectedY));
                m = picked;
                List<Cell> moves = m.getAvailableMoves(gameboard);
                for (Cell each : moves)
                {
                    if (gameboard.getType(each.getX(), each.getY())!=null)
                    {
                        cells[each.getX()][each.getY()].setBackground(ATTACK);
                        enemy = gameboard.getPiece(new Cell(each.getX(), each.getY()));
                   } else cells[each.getX()][each.getY()].setBackground(MOVES);
                }
            }

        }
        else
        {
            if (cells[x][y].getBackground().equals(MOVES))
            {
                gameboard.move(new Cell(selectedX,selectedY), new Cell(x, y));
                selected = false;
                turn();

                refresh();
            }
            if (cells[x][y].getBackground().equals(ATTACK))
            {
                gameboard.move(new Cell(selectedX,selectedY), new Cell(x, y));
                selected = false;
                gameboard.getLog().add(picked + " takes " + enemy);
                turn();

                refresh();
            }
        }
    }
    
    public void turn()
    {
        whiteTurn = !whiteTurn;
        readLog(gameboard.getLog());
        text.append(((whiteTurn)? "White " : "Black ") + "turn to move.\n");
    }
    public void readLog(GameLogger log)
    {
        while (!log.isEmpty())
        {
            text.append(log.poll() + "\n");
        }
        
    }
    
}

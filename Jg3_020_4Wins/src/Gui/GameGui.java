/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Bl.Value;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class GameGui extends JFrame
{
    private Bl.GameBl bl = null;
    
    private Map<String, JLabel> lables = new HashMap();
    private JPanel playGround;
    
    //+1 Aufgrund der Buttonreihe
    private int row = 6+1;
    private int col = 7;
    
    public GameGui() throws HeadlessException
    {
        super.setTitle("4-Wins");
        this.setLayout(new BorderLayout());
        addMenus();
        iniComp();
        super.setSize(600, 600);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniComp()
    { 
        //-1 Da die Buttons nicht mitgezählt werden
        bl = new Bl.GameBl(row-1, 8);
        
        Container con = this.getContentPane();
        
        playGround = new JPanel();
        playGround.setLayout(new GridLayout(row, col, 3, 3));
        
        for(int i = 0; i < col; i++)
        {
            JButton btn = new JButton();
            btn.setName(""+i);
            btn.setText("V");
            playGround.add(btn);
            
            btn.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent evt)
                {
                    onButtonClick(evt);
                }
            });
        }

        for(int i = 0; i < row-1; i++)
        {
            for(int j = 0; j < col; j++)
            {
                JLabel lb = new JLabel();
                lb.setName(""+i+""+j);
                lb.setText(""+i+""+j);
                
                lb.setOpaque(true);
                lb.setBackground(Color.black);
                
                lables.put(lb.getName(), lb);
                playGround.add(lb);
            }
        }
        
        con.add(playGround, BorderLayout.CENTER);
        this.pack();
    }
    
    public void addMenus()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        
        JMenuItem newGame = new JMenuItem("new Game");
        JMenuItem endGame = new JMenuItem("Cancle game");
        
        menu.add(newGame);
        menu.add(endGame);
        menuBar.add(menu);
        
        newGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                reset();
            }
        });
        
        endGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               System.exit(0);
            }
        });
        
        this.add(menuBar, BorderLayout.NORTH);
    }
    
    public void reset()
    {
        this.remove(playGround);
        iniComp();
        this.setSize(600,600);
    }
    
    public void onButtonClick(MouseEvent evt)
    {
        int col = Integer.parseInt(evt.getComponent().getName());
        
        try
        {
            int row = bl.makeMove(col);
            
            Bl.Value val = bl.getValueAt(row, col);
            
            JLabel lb = lables.get(""+(row)+""+col);
            
            switch(val)
            {
                case Player1: lb.setBackground(Color.red); break;
                case Player2: lb.setBackground(Color.blue); break;
            }
            
            Value winner = bl.checkWinner(row, col);
            
            if(winner.getNum() == Value.Player1.getNum())
                JOptionPane.showMessageDialog(this, "The Winner is: Player1");
            else if(winner.getNum() == Value.Player2.getNum())
                JOptionPane.showMessageDialog(this, "The Winner is: Player2");
            else if(winner.getNum() == Value.Draw.getNum())
                JOptionPane.showMessageDialog(this, "Its a draw");
            
            bl.changePlayer();
        } 
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void main(String[] args)
    {
        GameGui gui = new GameGui();
        gui.setVisible(true);
    }
}

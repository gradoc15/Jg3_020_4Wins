/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Bl.Value;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class GameGui extends JFrame
{
    private Bl.GameBl bl = null;
    
    private int row = 7;
    private int col = 7;
    
    private Map<String, JLabel> lables = new HashMap();
    
    public GameGui() throws HeadlessException
    {
        super.setTitle("4-Wins");
        iniComp();
        super.setSize(600, 600);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniComp()
    {
        lables.clear();
        bl = new Bl.GameBl();
        
        Container con = this.getContentPane();
        con.setLayout(new GridLayout(row, col, 3, 3));
        
        for(int i = 0; i < col; i++)
        {
            JButton btn = new JButton();
            btn.setName(""+i);
            btn.setText("V");
            con.add(btn);
            
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
                con.add(lb);
            }
        }
        
        
    }
    
    public void onButtonClick(MouseEvent evt)
    {
        System.out.println("Col: "+evt.getComponent().getName());
        int col = Integer.parseInt(evt.getComponent().getName());
        
        try
        {
            int row = bl.makeMove(col);
            
            Bl.Value val = bl.getValueAt(row, col);
            System.out.println("Gui--> "+row+" "+col);
            JLabel lb = lables.get(""+(row)+""+col);
            
            System.out.println(val);
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

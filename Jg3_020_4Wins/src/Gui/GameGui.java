/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class GameGui extends JFrame
{

    public GameGui() throws HeadlessException
    {
        super.setTitle("4-Wins");
        super.setSize(600, 600);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args)
    {
        GameGui gui = new GameGui();
        gui.setVisible(true);
    }
}

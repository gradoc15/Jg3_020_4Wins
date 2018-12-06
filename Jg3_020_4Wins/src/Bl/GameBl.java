/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class GameBl
{
    private Value[][] field = new Value[7][7];
    private Value currentPlayer;

    public GameBl()
    {
        currentPlayer = Value.Player1;
        
        for(int i = 0; i < field.length; i++)
        {
            Value[] row = field[i];
            
            for(int j = 0; j < row.length; j++)
            {
                field[i][j] = Value.Empty;
            }
        }
    }
    
    public int makeMove(int col)throws Exception
    {
        
        if(field[0][col].getNum() != Value.Empty.getNum())
            throw new Exception("Invalid move, field is already used");
   
        int row = -1;
        for(int i = field.length-1; i >= 0; i--)
        {
            System.out.println("Bl-Loop: "+i+" "+col);
            if(field[i][col].getNum() == Value.Empty.getNum())
            {
                field[i][col] = currentPlayer;
                row = i;
                
                System.out.println(field[i][col]);
                break;
            }
            
        }
        
        return row;
    }
    
    public Value checkWinner(int row, int col)
    {
        //###############################
        //Link Seitwärts
        int sumLeft = 0;
        int sumRight = 0;
        
        
        for(int i = 0; i < 4; i++)
        {
            if(col+i < field[5].length)
                sumRight += field[row][col+i].getNum();
            if(col-i >= 0)
                sumLeft += field[row][col-i].getNum();
        }
        
        if(sumLeft == 4 || sumLeft == -4)
            return currentPlayer;
        else if(sumRight == 4 || sumRight == -4)
            return currentPlayer;
        
        System.out.println("L: "+sumLeft);
        
        return Value.Empty;
        //###############################
    }
    
    public void changePlayer()
    {
        if(currentPlayer == Value.Player1)
            currentPlayer = Value.Player2;
        else if(currentPlayer == Value.Player2)
            currentPlayer = Value.Player1;
    }
    
    public Value getValueAt(int row, int col)
    {
        return field[row][col];
    }
    
    
}

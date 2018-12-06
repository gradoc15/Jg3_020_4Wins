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
    private Value[][] field = new Value[6][7];
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
        //Proof horizontal
        int sumLeft = 0;
        int sumRight = 0;
        
        
        for(int i = 0; i < 4; i++)
        {
            if(col+i < field[row].length)
                sumRight += field[row][col+i].getNum();
            if(col-i >= 0)
                sumLeft += field[row][col-i].getNum();
        }
        
        if(sumLeft == 4 || sumLeft == -4)
            return currentPlayer;
        else if(sumRight == 4 || sumRight == -4)
            return currentPlayer;
        
        //proof vertical
        int sumUp = 0;
        int sumDown = 0;
        
       for(int i = 0; i < 4; i++)
       {
           if(row-i >= 0)
               sumDown += field[row-i][col].getNum();
           if(row+i < field.length)
               sumUp += field[row+i][col].getNum();
           
           System.out.println("BL: "+row+" "+col);
               
       }
       
        System.out.println(sumUp);
       if(sumDown == 4 || sumDown == -4)
            return currentPlayer;
        else if(sumUp == 4 || sumUp == -4)
            return currentPlayer;
       
       //diagonal
       
       int sumDiaUpLeft = 0;
       int sumDiaUpRight = 0;
       int sumDiaDownLeft = 0;
       int sumDiaDownRight = 0;
       
       for(int i = 0; i < 4; i++)
       {
           if(row-i >= 0 && col-i >= 0)
               sumDiaUpLeft += field[row-i][col-i].getNum();
           if(row-i >= 0 && col+i < field[row].length)
               sumDiaUpRight += field[row-i][col+i].getNum();
           if(row+i < field.length && col-i >= 0)
               sumDiaDownLeft += field[row+i][col-i].getNum();
           if(row+i < field.length && col+i < field[row].length)
               sumDiaDownRight += field[row+i][col+i].getNum();
           
       }
       
       if(sumDiaUpLeft == 4 || sumDiaUpLeft == -4)
           return currentPlayer;
       else if(sumDiaUpRight == 4 || sumDiaUpRight == -4)
           return currentPlayer;
       else if(sumDiaDownLeft == 4 || sumDiaDownLeft == -4)
           return currentPlayer;
       else if(sumDiaDownRight == 4 || sumDiaDownRight == -4)
           return currentPlayer;
       
       if(testDraw())
           return Value.Draw;
       
        System.out.println("here");
        
        return Value.Empty;
        //###############################
    }
    
    public boolean testDraw()
    {
        
        for(int i = 0; i < field.length; i++)
        {
            Value[] row = field[i];
            
            for(int j = 0; j < row.length; j++)
            {
                if(field[i][j].getNum() == Value.Empty.getNum())
                    return false;
            }
        }
        
        return true;
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

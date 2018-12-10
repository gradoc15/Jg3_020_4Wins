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
    private Value[][] field;
    private Value currentPlayer;
    
    private boolean playableGame = true;

    public GameBl(int anzRow, int anzCol)
    {
        currentPlayer = Value.Player1;
        
        field = new Value[anzRow][anzCol];
        
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
        if(!playableGame)
            throw new Exception("The game is over, you can not make a move");
        if(field[0][col].getNum() != Value.Empty.getNum())
            throw new Exception("Invalid move, field is not aviable");
   
        int row = -1;
        for(int i = field.length-1; i >= 0; i--)
        {
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
        playableGame = false;
        
  
        //Proof horizontal
        int sumLeft = 0;
        int sumRight = 0;
        
//        for(int i = 0; i < 4; i++)
//        {
//            if(col+i < field[row].length)
//                sumRight += field[row][col+i].getNum();
//            if(col-i >= 0)
//                sumLeft += field[row][col-i].getNum();
//        }

        for(int i = 0; i < field.length; i++)
        {
            sumRight = 0;
            sumLeft = 0;
            
            for(int j = 0; j < field[i].length-3; j++)
            {
                sumRight += field[i][j].getNum();
            }
            
            for(int j = field[i].length-1; j > 2; j--)
            {
                sumLeft += field[i][j].getNum();
            }
                
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
       
 
       int sumDiaLeftDown = 0;
       int sumDiaRightDown = 0;
       //DiaLeftDown
        for (int i = field.length - 1; i > 2; i--) 
        {
            for (int k = 0; k < field.length - 3; k++) 
            {             
                sumDiaLeftDown = 0;
                for (int j = 0; j < 4; j++)
                    sumDiaLeftDown += field[i - j][j + k].getNum();
                
                if (sumDiaLeftDown == 4 ||sumDiaLeftDown == -4) 
                    return currentPlayer;
            }
        }
        
        //DiaRightDown
        for (int i = field.length - 1; i > 2; i--)
        {
            for (int k = 0; k < field.length - 2; k++) 
            {               
                sumDiaRightDown = 0;
                
                for (int j = 0; j < 4; j++)                     
                    sumDiaRightDown += field[i - j][3 - j + k].getNum();
                
                if (sumDiaRightDown == 4 ||sumDiaRightDown == -4)
                    return currentPlayer;
            }
        }
        
       if(testDraw())
           return Value.Draw;
        
        playableGame = true;
        
        return Value.Empty;
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

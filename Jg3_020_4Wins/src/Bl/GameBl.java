/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bl;

/**
 *
 * @author User
 */
public class GameBl
{
    private Value[][] field = new Value[7][6];
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
    
    public void makeMove(int col)throws Exception
    {
        if(field[0][col].getNum() != Value.Empty.getNum())
            throw new Exception("Invalid move, field is already used");
        
        for(int i = field.length-1; i > 0; i--)
        {
            field[i][col] = currentPlayer;
        }
        
        if(currentPlayer == Value.Player1)
            currentPlayer = Value.Player2;
        else if(currentPlayer == Value.Player2)
            currentPlayer = Value.Player1;
    }
    
    
}

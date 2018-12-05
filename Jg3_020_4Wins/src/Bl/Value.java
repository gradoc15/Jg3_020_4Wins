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
public enum Value
{
    Player1(1),
    Player2(-1),
    Empty(0),
    Draw(42);
    
    private int num;

    private Value(int num)
    {
        this.num = num;
    }
    
    public int getNum()
    {
        return num;
    }
}

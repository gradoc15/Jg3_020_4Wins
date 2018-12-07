/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bl;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author User
 */
public class GameBlTest
{
    @Parameter(value = 0)
    private int row;
    
    @Parameter(value = 1)
    private int col;
    
    @Parameter(value = 2)
    private int expectedMakeMove;
    
    @Parameters(name = "")
    public static Iterable<Object[]> data1()
    {
        return Arrays.asList(new Object[][]
        {
            {1.0, 2.0, 6.0},
            {-1.0, 2.0, 1.0,-3.0,-2.0,-0.5},
            {5.0, 3.0, 8.0,2.0,15.0,1.66666666666},
            {5.0, 3.0, 7.0,0.0,7.0,1.0}
                
        });
                 
    } 
    
    public GameBlTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of makeMove method, of class GameBl.
     */
    @Test
    public void testMakeMove() throws Exception
    {
        System.out.println("makeMove");
        GameBl instance = new GameBl();
        int result = instance.makeMove(col);
        assertEquals(this.expectedMakeMove, result);
    }

    /**
     * Test of checkWinner method, of class GameBl.
     */
    @Test
    public void testCheckWinner()
    {
        System.out.println("checkWinner");
        int row = 0;
        int col = 0;
        GameBl instance = new GameBl();
        Value expResult = null;
        Value result = instance.checkWinner(row, col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testDraw method, of class GameBl.
     */
    @Test
    public void testTestDraw()
    {
        System.out.println("testDraw");
        GameBl instance = new GameBl();
        boolean expResult = false;
        boolean result = instance.testDraw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePlayer method, of class GameBl.
     */
    @Test
    public void testChangePlayer()
    {
        System.out.println("changePlayer");
        GameBl instance = new GameBl();
        instance.changePlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class GameBl.
     */
    @Test
    public void testGetValueAt()
    {
        System.out.println("getValueAt");
        int row = 0;
        int col = 0;
        GameBl instance = new GameBl();
        Value expResult = null;
        Value result = instance.getValueAt(row, col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

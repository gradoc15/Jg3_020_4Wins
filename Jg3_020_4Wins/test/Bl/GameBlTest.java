package Bl;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class GameBlTest
{
    
    @Parameter(value = 0)
        public int sizeRow;
    @Parameter(value = 1)
        public int sizeCol;
    @Parameter(value = 2)
        public int row;
    @Parameter(value = 3)
        public int col;
    @Parameter(value = 4)
        public boolean ergTestDraw;
    @Parameter(value = 5)
        public Value actPlayer;
    @Parameter(value = 6)
        public Value ergChangePlayer;
    @Parameter(value = 7)
        public int move1;
    @Parameter(value = 8)
        public int move2;
    @Parameter(value = 9)
        public int move3;
    @Parameter(value = 10)
        public int move4;
    @Parameter(value = 11)
        public int move5;
    @Parameter(value = 12)
        public int move6;
    @Parameter(value = 13)
        public int move7;
    @Parameter(value = 14)
        public Value ergWinner;
    
    
    @Parameters(name = "")
    public static Iterable<Object[]> data1()
    {
        return Arrays.asList(new Object[][]
        {
            {6,7,5,1,false,Value.Player1,Value.Player2,1,5,2,5,3,5,4,Value.Empty},
            {8,8,7,1,false,Value.Player2,Value.Player1,1,2,6,4,5,6,7,Value.Player1}
                
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
        System.out.println("sizeR "+sizeRow);
        System.out.println("sizeC "+sizeCol );
        GameBl instance = new GameBl(sizeRow, sizeCol);
        int result = instance.makeMove(col);
        assertEquals(this.row, result);
    }

    /**
     * Test of checkWinner method, of class GameBl.
     */
    @Test
    public void testCheckWinner()throws Exception
    {
        System.out.println("checkWinner");
        
        GameBl instance = new GameBl(sizeRow, sizeCol);
        instance.makeMove(move1);
        instance.makeMove(move2);
        instance.makeMove(move3);
        instance.makeMove(move4);
        instance.makeMove(move5);
        instance.makeMove(move6);
        int row = instance.makeMove(move7);

        Value result = instance.checkWinner(row, col);
        assertEquals(ergWinner, result);
    }

    /**
     * Test of testDraw method, of class GameBl.
     */
    @Test
    public void testTestDraw()
    {
        System.out.println("testDraw");
        GameBl instance = new GameBl(sizeRow, sizeCol);
        boolean result = instance.testDraw();
        assertEquals(ergTestDraw, result);
    }

    /**
     * Test of changePlayer method, of class GameBl.
     */
    @Test
    public void testChangePlayer()
    {
        System.out.println("changePlayer");
        GameBl instance = new GameBl(sizeRow, sizeCol);
        instance.setPlayer(actPlayer);  
        instance.changePlayer();
        assertEquals(instance.getCurrentPlayer(), ergChangePlayer);
    }

    /**
     * Test of getValueAt method, of class GameBl.
     */
    @Test
    public void testGetValueAt()
    {
        System.out.println("getValueAt");
        GameBl instance = new GameBl(sizeRow, sizeCol);
        Value expResult = Value.Empty;
        Value result = instance.getValueAt(row, col);
        assertEquals(expResult, result);
    }
    
}

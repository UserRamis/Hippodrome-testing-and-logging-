import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import org.mockito.MockedStatic;
import org.mockito.Mockito;



import static org.junit.Assert.assertThrows;

public class HorseTest extends TestCase {




    @Test
    public void testGetExceptionForNull()
    {
        assertThrows(IllegalArgumentException.class,()-> new Horse(null,1,1));



    }


    @Test
    public void testGetNullExceptionMessage()
    {
        try {
            new Horse(null,1,1);
            fail();
        }
        catch (IllegalArgumentException e)
        {
           assertEquals("Name cannot be null.",e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { " ", "\n","\t"})
    public void testSpaceorTabulation(String argument)
    {
        assertThrows(IllegalArgumentException.class, ()->new Horse(argument,1,1));
    }


    @ParameterizedTest
    @ValueSource(strings = { " ", "\n","\t"})
    public void testParametrsGetNullExceptionMessage(String argument)
    {
        try {
            new Horse(argument,1,1);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Name cannot be blank.", e.getMessage());
        }
    }

    @Test
    public void testNegativeParametrForSpeed()
    {
        assertThrows(IllegalArgumentException.class,()->new Horse("lida",-2,1));
    }

    @Test
    public void testGetMessageNegativeParametrForSpeed()
    {
        try {
            new Horse("lida",-2,2);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Speed cannot be negative.",e.getMessage());
        }
    }


    @Test
    public void testNegativeParametrForDistance()
    {
        assertThrows(IllegalArgumentException.class,()->new Horse("lida",2,-1));
    }

    @Test
    public void testGetMessageNegativeParametrForDistance()
    {
        try {
            new Horse("lida",2,-2);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Distance cannot be negative.",e.getMessage());
        }
    }

    public void testTestGetName()
    {
        Horse horse=new Horse("lida",1,1);
        String result=horse.getName();
        assertEquals("lida",result);
    }


    @Test
    public void testGetSpeed()
    {
        Horse horse=new Horse("lida",1,1);
        double result=horse.getSpeed();
        assertEquals(1.0,result);
    }
    @Test
    public void testGetDistance()
    {
        Horse horse=new Horse("lida",1,2);
        double result=horse.getDistance();
        assertEquals(2.0,result);
    }

    @Test
    public void testGetDistanceForTwoParametres()
    {
        Horse horse=new Horse("lida",1);
        double result=horse.getDistance();
        assertEquals(0.0,result);
    }


    @Test
    public void testMove()
    {
        try (MockedStatic<Horse> utilities =  Mockito.mockStatic(Horse.class)){
            new Horse("lida",31,23).move();

            utilities.verify(()->Horse.getRandomDouble(0.2,0.9));
        }

    }

}
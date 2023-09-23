import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class HippodromeTest extends TestCase {


    @Test
    public void testGetExceptionForNull()
    {
        assertThrows(IllegalArgumentException.class,()->new Hippodrome(null));
    }

    @Test
    public void testGetNullExceptionMessage()
    {
        try {
            new Hippodrome(null);
            fail();
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Horses cannot be null.", e.getMessage());
        }
    }

    @Test
    public void testGetExceptionForEmpty()
    {
        assertThrows(IllegalArgumentException.class,()->new Hippodrome(new ArrayList<>()));
    }

    @Test
    public void testGetNullExceptionMessageForEmpty()
    {
        try {
            new Hippodrome(new ArrayList<>());
            fail();
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Horses cannot be empty.", e.getMessage());
        }
    }




    @Test
    public void testGetHorses()
    {
        List<Horse> horses=new ArrayList<>();
        for (int i = 0; i < 30; i++)
        {
            horses.add(new Horse(" "+i,i,i));
        }
        Hippodrome hippodrome=new Hippodrome(horses);
        assertEquals(hippodrome.getHorses(),horses);
    }


    @Test
    public void testMove()
    {
        List<Horse> horses=new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        new Hippodrome(horses).move();
        for (Horse horse:horses)
        {
            verify(horse, times(1)).move();
        }
    }



    @Test
    public void testGetWinner()
    {
        Horse horse1=new Horse("lida",1 ,1);
        Horse horse2=new Horse("lida",1 ,2);
        Horse horse3=new Horse("lida",1 ,3);
        Horse horse4=new Horse("lida",1 ,4);

        Hippodrome hippodrome=new Hippodrome(List.of(horse1,horse2,horse3,horse4));
        assertEquals(horse4,hippodrome.getWinner());
    }








}
package Lab4.Tests;

import Lab4.Triangle.Triangle;
import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void isAvaliableZeroArgs(){
        assertFalse(Triangle.isAvaliable(0,0,0));
    }

    @Test
    public void isAvaliableFalseIntArgs(){
        assertFalse(Triangle.isAvaliable(1,2,3));
    }

    @Test
    public void isAvaliableTrueIntArgs(){
        assertTrue(Triangle.isAvaliable(1,1,1));
    }

    @Test
    public void isAvaliableNegativeArgs(){
        assertFalse(Triangle.isAvaliable(1,-1,1));
    }

    @Test
    public void isAvaliableTrueDoubleArgs(){
        assertTrue(Triangle.isAvaliable(0.5,0.6,0.7));
    }

    @Test
    public void isAvaliableFalseDoubleArgs(){
        assertFalse(Triangle.isAvaliable(0.4,0.1,0.7));
    }

    @Test
    public void isAvaliablePeriodTrue(){
        assertFalse(Triangle.isAvaliable(1/3,1,1));
    }

    @Test
    public void isAvaliableSQRT(){
        assertFalse(Triangle.isAvaliable(Math.sqrt(-1),1,1));
    }

    @Test
    public void isAvaliableString(){
        assertFalse(Triangle.isAvaliable(1,1, Double.parseDouble("3")));
    }

    @Test
    public void isAvaliable8(){
        assertTrue(Triangle.isAvaliable(1,1, Double.parseDouble("1")));
    }
}
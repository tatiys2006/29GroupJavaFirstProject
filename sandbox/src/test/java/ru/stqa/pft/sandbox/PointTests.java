package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by tetyana.kostyrkina on 4/18/2016.
 */
public class PointTests {

    @Test
    public void testDistanceValue(){
        Point p = new Point(1.0, 1, 2, 1.0);
        Assert.assertEquals(p.distance(), 1.0);
    }

    @Test
    public void testDistanceZero(){
        Point p = new Point(2, 1, 2, 1);
        Assert.assertEquals(p.distance(), 0.0);
    }

    @Test
    public void testDistanceNegative(){
        Point p = new Point(1, 1, 2, 1);
        Assert.assertEquals(p.distance(), 1.0);
    }


}

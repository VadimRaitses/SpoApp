package com.example.demo.services.optimization;

import com.example.demo.exceptions.OptimizationException;
import com.example.demo.models.Room;
import org.junit.Assert;
import org.junit.Test;

public class IterativeVsRecursiveTest extends StrategyAssertionMock{



    @Test
    public void iterativeVsRecursiveTest() {
        Assert.assertEquals(classUnderTestIterative.optimize(5, 3, 2), classUnderTestRecursive.optimize(5, 3, 2));
        Assert.assertEquals(classUnderTestIterative.optimize(35, 10, 6), classUnderTestRecursive.optimize(35, 10, 6));
        Assert.assertEquals(classUnderTestIterative.optimize(21, 10, 6), classUnderTestRecursive.optimize(21, 10, 6));
        Assert.assertEquals(classUnderTestIterative.optimize(17, 10, 6), classUnderTestRecursive.optimize(17, 10, 6));
        Assert.assertEquals(classUnderTestIterative.optimize(24, 11, 6), classUnderTestRecursive.optimize(24, 11, 6));
        Assert.assertEquals(classUnderTestIterative.optimize(28, 11, 6), classUnderTestRecursive.optimize(28, 11, 6));
    }




    @Test
    public void optimizeIterativeTest() {

        Assert.assertEquals(classUnderTestIterative.optimize(5, 3, 2), new Room(1, 1, 5, 2));
        Assert.assertEquals(classUnderTestIterative.optimize(35, 10, 6), new Room(3, 1, 36, 4));
        Assert.assertEquals(classUnderTestIterative.optimize(21, 10, 6), new Room(1, 2, 22, 3));
        Assert.assertEquals(classUnderTestIterative.optimize(17, 10, 6), new Room(2, 0, 20, 2));
        Assert.assertEquals(classUnderTestIterative.optimize(24, 11, 6), new Room(2, 1, 28, 3));
        Assert.assertEquals(classUnderTestIterative.optimize(28, 11, 6), new Room(2, 1, 28, 3));
    }

    @Test(expected = OptimizationException.class)
    public void exceptionforJuniorIterativeTest() {
        Assert.assertEquals(classUnderTestIterative.optimize(28, 0, 6), new Room(0, 1, 28, 3));
    }


    @Test(expected = OptimizationException.class)
    public void exceptionForCapasityIterativeTest() {
        Assert.assertEquals(classUnderTestIterative.optimize(0, 11, 6), new Room(0, 1, 28, 3));
    }

    @Test
    public void optimizeRecursiveTest() {
        Assert.assertEquals(classUnderTestRecursive.optimize(5, 3, 2), new Room(1, 1, 5, 2));
        Assert.assertEquals(classUnderTestRecursive.optimize(35, 10, 6), new Room(3, 1, 36, 4));
        Assert.assertEquals(classUnderTestRecursive.optimize(21, 10, 6), new Room(1, 2, 22, 3));
        Assert.assertEquals(classUnderTestRecursive.optimize(17, 10, 6), new Room(2, 0, 20, 2));
        Assert.assertEquals(classUnderTestRecursive.optimize(24, 11, 6), new Room(2, 1, 28, 3));
        Assert.assertEquals(classUnderTestRecursive.optimize(28, 11, 6), new Room(2, 1, 28, 3));
    }

    @Test(expected = OptimizationException.class)
    public void exceptionforJuniorRecursiveTest() {
        Assert.assertEquals(classUnderTestRecursive.optimize(28, 0, 6), new Room(0, 1, 28, 3));
    }

    @Test(expected = OptimizationException.class)
    public void exceptionForCapasityRecursiveTest() {
        Assert.assertEquals(classUnderTestRecursive.optimize(0, 11, 6), new Room(0, 1, 28, 3));
    }



}
//package com.example.demo.services.optimization;
//
//import com.example.demo.exceptions.OptimizationException;
//import com.example.demo.models.Room;
//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class RecursiveOptStrategyTest {
//
//    final RecursiveOptStrategy<Room> classUnderTest = new RecursiveOptStrategy<>();
//
//
//    @Test
//    public void optimize() {
//
//        Assert.assertEquals(classUnderTest.optimize(5, 3, 2), new Room(1, 1, 5, 2));
//        Assert.assertEquals(classUnderTest.optimize(35, 10, 6), new Room(3, 1, 36, 4));
//        Assert.assertEquals(classUnderTest.optimize(21, 10, 6), new Room(1, 2, 22, 3));
//        Assert.assertEquals(classUnderTest.optimize(17, 10, 6), new Room(2, 0, 20, 2));
//        Assert.assertEquals(classUnderTest.optimize(24, 11, 6), new Room(2, 1, 28, 3));
//        Assert.assertEquals(classUnderTest.optimize(28, 11, 6), new Room(2, 1, 28, 3));
//    }
//
//    @Test(expected = OptimizationException.class)
//    public void exceptionforJunior() {
//
//        Assert.assertEquals(classUnderTest.optimize(28, 0, 6), new Room(0, 1, 28, 3));
//
//    }
//
//
//    @Test(expected = OptimizationException.class)
//    public void exceptionForCapasity() {
//
//        Assert.assertEquals(classUnderTest.optimize(0, 11, 6), new Room(0, 1, 28, 3));
//
//    }
//}
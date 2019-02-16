package com.example.demo.services.optimization;

import com.example.demo.models.Room;
import org.junit.Before;

public class StrategyAssertionMock {


    final IterativeOptStrategy<Room> classUnderTestIterative = new IterativeOptStrategy<>();
    final RecursiveOptStrategy<Room> classUnderTestRecursive = new RecursiveOptStrategy<>();

    @Before
    public void setUp(){
        classUnderTestIterative.minimalSeniorAppearance = 1;
        classUnderTestRecursive.minimalSeniorAppearance = 1;
    }

}

package com.example.demo.services;

import com.example.demo.models.OptimizationRequest;
import com.example.demo.models.Room;
import com.example.demo.services.optimization.IOptStrategy;
import com.example.demo.services.optimization.IterativeOptStrategy;
import com.example.demo.services.optimization.RecursiveOptStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoomOptimisationServiceTest {


    private RoomOptimisationService classUnderTest;
    private final Map<String, IOptStrategy<Room>> optimizationStrategies = new HashMap();
    private IterativeOptStrategy iterativeStrategyMock = mock(IterativeOptStrategy.class);
    private RecursiveOptStrategy recursiveStrategyMock = mock(RecursiveOptStrategy.class);


    @Before
    public void setUp() throws Exception {
        optimizationStrategies.put("recursiveStrategy", recursiveStrategyMock);
        optimizationStrategies.put("iterativeStrategy", iterativeStrategyMock);
    }


    @Test
    public void recursiveTest() {

        classUnderTest = new RoomOptimisationService(optimizationStrategies);
        when(recursiveStrategyMock.optimize(35, 10, 6)).thenReturn(new Room(3, 1, 36, 4));
        List<Room> expected = Arrays.asList(new Room(3, 1, 36, 4));
        List<Room> actual = classUnderTest.optimize("recursiveStrategy", new OptimizationRequest(10, 6, Arrays.asList(35)));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void iterativeTest() {

        classUnderTest = new RoomOptimisationService(optimizationStrategies);
        when(iterativeStrategyMock.optimize(35, 10, 6)).thenReturn(new Room(3, 1, 36, 4));
        List<Room> expected = Arrays.asList(new Room(3, 1, 36, 4));
        List<Room> actual = classUnderTest.optimize("iterativeStrategy", new OptimizationRequest(10, 6, Arrays.asList(35)));
        Assert.assertEquals(expected, actual);
    }

}
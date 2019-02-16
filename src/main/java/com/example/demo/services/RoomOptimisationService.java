package com.example.demo.services;

import com.example.demo.models.OptimizationRequest;
import com.example.demo.models.Room;
import com.example.demo.services.optimization.IOptStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class RoomOptimisationService implements IRoomOptimizationService {

    private final Map<String, IOptStrategy<Room>> optimizationStrategies;

     RoomOptimisationService(Map<String, IOptStrategy<Room>> optimizationStrategies) {
        this.optimizationStrategies = optimizationStrategies;
    }

    @Override
    public List<Room> optimize(String strategy, OptimizationRequest roomRequest) {
        return roomRequest.getRooms().stream().map(e ->
                optimizationStrategies.get(strategy).optimize(e,
                        roomRequest.getSenior(),
                        roomRequest.getJunior())).collect(Collectors.toList());
    }
}

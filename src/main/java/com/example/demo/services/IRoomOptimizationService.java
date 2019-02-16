package com.example.demo.services;

import com.example.demo.models.OptimizationRequest;
import com.example.demo.models.Room;

import java.util.List;

public interface IRoomOptimizationService {

    List<Room> optimize(String strategy, OptimizationRequest roomRequest);
}

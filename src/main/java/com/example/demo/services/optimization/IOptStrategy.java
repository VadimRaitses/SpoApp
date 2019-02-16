package com.example.demo.services.optimization;


import com.example.demo.exceptions.OptimizationException;
import com.example.demo.models.Room;

public interface IOptStrategy<T extends Room> {


     T optimize(int capacity, int senior, int junior) throws OptimizationException;
}

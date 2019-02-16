package com.example.demo.services.optimization;

import com.example.demo.exceptions.OptimizationException;
import org.springframework.beans.factory.annotation.Value;

abstract class AbstractStrategyBase implements IOptStrategy {

    @Value("${MINIMAL.SENIOR}")
    int minimalSeniorAppearance;

    void validateInput(int capacity,int senior){
        if (capacity == 0)
            throw new OptimizationException("set capacity greater than 0");
        if (senior == 0)
            throw new OptimizationException("provide more than one seniorcleaner");
    }
}

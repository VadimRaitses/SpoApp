package com.example.demo.services.optimization;

import com.example.demo.exceptions.OptimizationException;
import com.example.demo.models.Room;

public class RecursiveOptStrategy<T extends Room> extends AbstractStrategyBase {

     RecursiveOptStrategy() {
    }

    @Override
    public T optimize(int capacity, int senior, int junior) {
        this.validateInput(capacity,senior);
        return (T) this.rec(capacity, new Room(), senior, junior);
    }

    private Room rec(int capacity, Room room, int senior, int junior) {
        if (capacity <= 0)
            return room;
        Room roomSenior = rec(capacity - senior, room.clone().incrementSeniorAmount().setWeight(senior), senior, junior);
        Room roomJunior = rec(capacity - junior, room.clone().incrementJuniorAmount().setWeight(junior), senior, junior);
        if (roomSenior.getWeight() >= capacity &&
                roomJunior.getWeight() >= capacity &&
                roomJunior.getSeniorAmount() >= this.minimalSeniorAppearance &&
                roomSenior.getSeniorAmount() >= this.minimalSeniorAppearance)
            if (roomSenior.getWeight() > roomJunior.getWeight())
                return roomJunior;
        return roomSenior;
    }
}

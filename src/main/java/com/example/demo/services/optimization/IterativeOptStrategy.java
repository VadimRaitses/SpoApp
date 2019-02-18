package com.example.demo.services.optimization;

import com.example.demo.models.Room;

import java.util.ArrayList;
import java.util.List;

public class IterativeOptStrategy<T extends Room> extends AbstractStrategyBase {



    public IterativeOptStrategy() {
    }

    @Override
    public T optimize(int capacity, int senior, int junior) {

        this.validateInput(capacity,senior);
        return (T) this.iterate(capacity, senior, junior);
    }

    private Room iterate(int capacity, double senior, double junior) {
        int maxSenior = (int) Math.ceil(capacity / senior);
        int maxJunior = (int) Math.ceil(capacity / junior);
        Room bestRoom = new Room();
        int sum = 0;
        for (int i = this.minimalSeniorAppearance; i < maxSenior + this.minimalSeniorAppearance; i++) {
            sum += senior * i;
            for (int j = 0; j < maxJunior; j++) {
                if (j != 0)
                    sum += junior;

                if (sum >= capacity) {
                    if (bestRoom.getWeight() < sum && bestRoom.getWeight() < capacity)
                        bestRoom = new Room(i, j, sum, i + j);
                    else if (bestRoom.getWeight() > sum)
                        bestRoom = new Room(i, j, sum, i + j);
                }
            }
            sum = 0;
        }
        return bestRoom;
    }
}

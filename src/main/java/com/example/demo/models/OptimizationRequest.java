package com.example.demo.models;
import java.util.List;

public class OptimizationRequest {

   private int senior;
   private int junior;
   private List<Integer> rooms;

    public OptimizationRequest() {
    }

    public OptimizationRequest(int senior, int junior, List<Integer> rooms) {
        this.senior = senior;
        this.junior = junior;
        this.rooms = rooms;
    }

    public int getSenior() {
        return senior;
    }

    public OptimizationRequest setSenior(int senior) {
        this.senior = senior;
        return this;
    }

    public int getJunior() {
        return junior;
    }

    public OptimizationRequest setJunior(int junior) {
        this.junior = junior;
        return this;
    }

    public List<Integer> getRooms() {
        return rooms;
    }

    public OptimizationRequest setRooms(List<Integer> rooms) {
        this.rooms = rooms;
        return this;
    }
}

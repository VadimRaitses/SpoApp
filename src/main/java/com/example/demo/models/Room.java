package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Room  {


    @JsonProperty(value = "senior")
    private int seniorAmount;
    @JsonProperty(value = "junior")
    private int juniorAmount;
    @JsonIgnore
    private int allAmount;
    @JsonIgnore
    private int weight;

    public Room() {
        this.seniorAmount = 0;
        this.juniorAmount = 0;
        this.weight = 0;
        this.allAmount = 0;
    }

    public Room(int seniorAmount, int junioAmount, int weight, int allAmount) {
        this.seniorAmount = seniorAmount;
        this.juniorAmount = junioAmount;
        this.weight = weight;
        this.allAmount = allAmount;
    }

    public int getSeniorAmount() {
        return seniorAmount;
    }

    public Room incrementSeniorAmount() {
        ++this.seniorAmount;
        ++this.allAmount;
        return this;
    }

    public int getJuniorAmount() {
        return juniorAmount;
    }

    public Room incrementJuniorAmount() {
        ++this.juniorAmount;
        ++this.allAmount;

        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Room setWeight(int weight) {
        this.weight += weight;
        return this;
    }

    @Override
    public Room clone() {
        return new Room(seniorAmount, juniorAmount, weight, allAmount);
    }

    @Override
    public String toString() {
        return "{:seniorAmount:" + seniorAmount
                + " :juniorAmount:" + juniorAmount
                + " :allAmount:" + allAmount
                + " :weight:" + weight + "}";

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (seniorAmount != room.seniorAmount) return false;
        if (juniorAmount != room.juniorAmount) return false;
        if (allAmount != room.allAmount) return false;
        return weight == room.weight;
    }

    @Override
    public int hashCode() {
        int result = seniorAmount;
        result = 31 * result + juniorAmount;
        result = 31 * result + allAmount;
        result = 31 * result + weight;
        return result;
    }
}

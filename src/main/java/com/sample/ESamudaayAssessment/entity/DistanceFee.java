package com.sample.ESamudaayAssessment.entity;

public class DistanceFee {
    int fees;
    int distance;

    public DistanceFee(int fees, int distance) {
        this.fees = fees;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public int getFees() {
        return fees;
    }
}

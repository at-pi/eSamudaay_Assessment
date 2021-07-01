package com.sample.ESamudaayAssessment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Order {

    @JsonProperty(value = "order_items")
    private List<OrderItem> orderItems;
    private int distance;
    private Offer offer;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}

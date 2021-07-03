package com.sample.ESamudaayAssessment.service;

import com.sample.ESamudaayAssessment.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class OrderService {

    private List<DistanceFee> distanceFees;

    @PostConstruct
    public void init() {
        distanceFees = new ArrayList<>();
        distanceFees.add(new DistanceFee(5_000, 10));
        distanceFees.add(new DistanceFee(10_000, 20));
        distanceFees.add(new DistanceFee(50_000, 50));
        distanceFees.add(new DistanceFee(100_000, Integer.MAX_VALUE));
    }

    public OrderResponse calculateTotal(Order order) { //method to calculate total price of the order
        OrderResponse orderResponse = new OrderResponse();
        long orderTotal = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            orderTotal += orderItem.getPrice() * orderItem.getQuantity();
        }
        System.out.println("order items total " + orderTotal);

        int deliveryFees = calculateDeliveryFees(order.getDistance());
        System.out.println("delivery fees " + deliveryFees);
        orderTotal += deliveryFees;

        if (order.getOffer() != null) {
            System.out.println("applying offer: " + order.getOffer().getOfferType());
            long discount = findBestDiscount(order.getOffer(), deliveryFees);
            orderTotal -= discount;
        }

        orderTotal = orderTotal < 0 ? 0 : orderTotal; //setting total to be 0 if negative
        System.out.println("final order total: " + orderTotal);
        orderResponse.setOrderTotal(orderTotal);
        return orderResponse;
    }

    private long findBestDiscount(Offer offer, int deliveryFees) { //handles case for FLAT and DELIVERY type of discounts
        switch (offer.getOfferType()) {
            case FLAT:
                return offer.getOfferVal();
            case DELIVERY:
                return deliveryFees;
        }
        return 0;
    }

    private int calculateDeliveryFees(int distance) {
        //creating dummy distance fees object for binary search
        DistanceFee df = new DistanceFee(-1, distance);

        int distanceFeeIndex = Collections.binarySearch(distanceFees, df, new Comparator<DistanceFee>() { //defined comparator for binary search in distance fees list of distance fee structure
            @Override
            public int compare(DistanceFee o1, DistanceFee o2) {
                return o1.getDistance() - o2.getDistance();
            }
        });
        distanceFeeIndex = distanceFeeIndex < 0 ? distanceFeeIndex + distanceFees.size() : distanceFeeIndex; //calculating the index where distance falls
        return distanceFees.get(distanceFeeIndex).getFees();
    }
}

package com.sample.ESamudaayAssessment.service;

import com.sample.ESamudaayAssessment.entity.Order;
import com.sample.ESamudaayAssessment.entity.OrderItem;

import java.util.List;

public class CheckOrderService {

    public boolean checkOrder(Order order){

        List<OrderItem> orderItems = order.getOrderItems();

        for(OrderItem orderItem : orderItems){
            if(orderItem.getQuantity()>20)
                return false;
            if(orderItem.getPrice()>999999)
                return false;
        }

        if(order.getDistance()>)
        return true;
    }

}

package com.sample.ESamudaayAssessment.service.validator;

import com.sample.ESamudaayAssessment.entity.Order;
import com.sample.ESamudaayAssessment.entity.OrderItem;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderValidator { //validator service based defined contants which can modified

    public boolean validateItems(List<OrderItem> orderItems){

        for(OrderItem orderItem : orderItems){
            if(orderItem.getQuantity()>20)
                return false;
            if(orderItem.getPrice()>999999)
                return false;
        }
        return true;
    }

    public boolean validateDistance(Order order) {
        if(order.getDistance()> 500000  || order.getDistance()<0)
            return false;

        return true;
    }

}

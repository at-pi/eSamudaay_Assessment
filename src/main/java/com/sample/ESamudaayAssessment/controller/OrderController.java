package com.sample.ESamudaayAssessment.controller;


import com.sample.ESamudaayAssessment.entity.Order;
import com.sample.ESamudaayAssessment.entity.OrderResponse;
import com.sample.ESamudaayAssessment.service.OrderService;
import com.sample.ESamudaayAssessment.service.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController { //main controller for the application

    @Autowired
    private OrderService calculateTotalService; //creating autowired ojects for singleton type creation

    @Autowired
    private OrderValidator orderValidator;

    @PostMapping("/order")
    @ResponseBody
    public OrderResponse orderItems(@RequestBody Order order) {
        OrderResponse orderResponse = new OrderResponse(); //object for response changes its structure for output json based on null values
        try {
            boolean areItemsValid = orderValidator.validateItems(order.getOrderItems());
            if (!areItemsValid) {
                orderResponse.setCode(2000); //defined codes it can be modified based later
                orderResponse.setMessage("item quantity/price is more than allowed limit"); //custom message for invalid input
                return orderResponse;
            }

            boolean isDistanceValid = orderValidator.validateDistance(order);
            if (!isDistanceValid) {
                orderResponse.setCode(2001);
                orderResponse.setMessage("delivery distance is more than allowed limit");
                return orderResponse;
            }

            //service call
            orderResponse = calculateTotalService.calculateTotal(order);
            return orderResponse;
        } catch (Exception e) {
            System.out.println("error occurred during order placement: " + e.getMessage());
            e.printStackTrace();
            orderResponse.setCode(3000);
            orderResponse.setMessage("error occurred during order placement");
            return orderResponse;
        }

    }
}

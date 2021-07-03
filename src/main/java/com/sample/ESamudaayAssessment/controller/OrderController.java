package com.sample.ESamudaayAssessment.controller;


import com.sample.ESamudaayAssessment.entity.Order;
import com.sample.ESamudaayAssessment.entity.OrderResponse;
import com.sample.ESamudaayAssessment.service.CalculateTotalService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/order")
    @ResponseBody
    public OrderResponse orderItems(@RequestBody Order order) {
        OrderResponse orderResponse = new OrderResponse();
        try {
            //service call
            CalculateTotalService calculateTotalService = new CalculateTotalService();
            orderResponse = calculateTotalService.calculateTotal(order);
            return orderResponse;
        } catch (Exception e) {
            orderResponse.setCode(1001);
            orderResponse.setMessage("sdf");
            return orderResponse;
        }

    }
}

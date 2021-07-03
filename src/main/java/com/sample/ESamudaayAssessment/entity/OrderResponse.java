package com.sample.ESamudaayAssessment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class OrderResponse extends BaseResponse {

    @JsonProperty(value = "order_total")
    private int orderTotal;

    public int getOrderTotal() {
        return orderTotal;
    }

}

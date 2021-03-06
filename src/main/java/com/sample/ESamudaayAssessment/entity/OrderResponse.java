package com.sample.ESamudaayAssessment.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse extends BaseResponse { //final order Response entity only included if value of not in in the final Json

    @JsonProperty(value = "order_total")
    private Long orderTotal;

    public Long getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Long orderTotal) {
        this.orderTotal = orderTotal;
    }
}

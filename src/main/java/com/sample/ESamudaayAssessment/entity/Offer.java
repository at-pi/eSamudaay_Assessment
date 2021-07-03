package com.sample.ESamudaayAssessment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

public class Offer {

    @JsonProperty(value = "offer_type")
    private OfferType offerType;

    @JsonProperty(value = "offer_val")
    private int offerVal;

    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public int getOfferVal() {
        return offerVal;
    }

    public void setOfferVal(int offerVal) {
        this.offerVal = offerVal;
    }
}

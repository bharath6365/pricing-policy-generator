package com.bharath6365.pricing.common.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Pricing{
    @JsonProperty("pricingType")
    private PricingType pricingType;

    @JsonProperty("firstEmiDate")
    private int firstEmiDate;

    @JsonProperty("principal")
    private float principal;

    @JsonProperty("interestRate")
    private float interestRate;

    @JsonProperty("tenureInMonths")
    private int tenureInMonths;

    @JsonProperty("processingFee")
    private float processingFee;

    @JsonProperty("foreClosureCharges")
    private float foreClosureCharges;

    @JsonProperty("approvalStatus")
    private boolean approvalStatus;

    @JsonProperty("rejectionReason")
    private String rejectionReason;

}

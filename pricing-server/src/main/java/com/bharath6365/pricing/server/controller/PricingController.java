package com.bharath6365.pricing.server.controller;

import com.bharath6365.pricing.common.entities.Customer;
import com.bharath6365.pricing.common.entities.Pricing;
import com.bharath6365.pricing.server.service.PricingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pricing")
public class PricingController {
    @Autowired
    private PricingService pricingService;

    @PostMapping
    public Optional<Pricing> getPricing(
            @Valid @RequestBody Customer customer
            ) {
        return pricingService.getPricing(customer);
    }
}

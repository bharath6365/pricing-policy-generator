package com.bharath6365.pricing.server.controller;

import com.bharath6365.pricing.server.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bharath6365.pricing.server.models.Rule;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @GetMapping
    public List<Rule> getAllRules() {
        return ruleService.getAllRules();
    }
}
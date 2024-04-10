package com.bharath6365.pricing.engine.entities;

import java.util.List;
import java.util.Map;
import  java.util.HashMap;
import java.util.Optional;

import com.bharath6365.pricing.common.entities.PricingType;
import com.bharath6365.pricing.engine.parser.DSLParser;
import com.bharath6365.pricing.engine.parser.MvelParser;
import  com.bharath6365.pricing.common.entities.Customer;
import  com.bharath6365.pricing.common.entities.Pricing;
import com.bharath6365.pricing.engine.rules.RuleEngine;
import  com.bharath6365.pricing.engine.rules.RuleEngineType;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricingRuleEngine extends RuleEngine<Customer, PricingRule, Pricing> {

    private DSLParser dslParser;
    private MvelParser mvelParser;

    private RuleEngineType ruleEngineType;

    private int id;
    private int version;

    public PricingRuleEngine(RuleEngineType ruleEngineType, int id, int version) {
        super(ruleEngineType, id, version);
    }


    @Override
    public Optional<Pricing> executeRules(Customer customer, List<PricingRule> rules) {
        System.out.println("Executing rules for customer: " + customer.toString());
        Map<String, Object> context = new HashMap<>();
        Pricing pricing = Pricing.builder().pricingType(PricingType.PERSONAL_LOAN).build();
        context.put("input", customer);
        context.put("output", pricing);
        for (int i = 0; i < rules.size(); i++) {
            PricingRule rule = rules.get(i);
            String ruleConditionWithoutDSL = this.getDslParser().parseRule(rule.getCondition());
            rule.setCondition(ruleConditionWithoutDSL);

            boolean conditionResult = this.getMvelParser().parseCondition(rule.getCondition(), context);
            if (conditionResult) {
                this.getMvelParser().executeAction(rule.getAction(), context);
                if (rule.isTerminal()) {
                    break;
                }
            }

        }

        return Optional.of(pricing);
    }

}


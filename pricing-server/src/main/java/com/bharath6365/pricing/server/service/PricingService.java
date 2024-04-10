package com.bharath6365.pricing.server.service;

import com.bharath6365.pricing.common.entities.Customer;
import com.bharath6365.pricing.common.entities.Pricing;
import com.bharath6365.pricing.common.entities.RuleType;
import com.bharath6365.pricing.engine.entities.PricingRule;
import com.bharath6365.pricing.engine.entities.PricingRuleEngine;
import com.bharath6365.pricing.server.models.Rule;
import com.bharath6365.pricing.server.util.PricingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PricingService {

    @Autowired
    private PricingRuleEngine pricingRuleEngine;

    @Autowired
    private RuleService ruleService;

    public Optional<Pricing> getPricing(Customer customer) {
       final List<Rule> rules = ruleService.getAllRules();
       List<Rule> sortedRules = new ArrayList<>();

       rules.stream().filter(rule -> rule.getRuleType() == RuleType.PERSONAL_LOAN_LENDER).forEach(sortedRules::add);
       rules.stream().filter(rule -> rule.getRuleType() == RuleType.PERSONAL_LOAN_ELIGIBILITY).forEach(sortedRules::add);
       rules.stream().filter(rule -> rule.getRuleType() == RuleType.PERSONAL_LOAN_RISK).forEach(sortedRules::add);

       List<PricingRule> pricingRules = new ArrayList<>();

         sortedRules.forEach(rule -> {
             pricingRules.add(PricingUtil.getPricingRuleFromDbRule(rule));
         });


       try {
           return pricingRuleEngine.executeRules(customer, pricingRules);
       } catch (Error error) {
          System.out.println("Error while evaluating rules" + rules);
          return Optional.empty();
       }

    }
}

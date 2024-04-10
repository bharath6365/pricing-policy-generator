package com.bharath6365.pricing.server.util;

import com.bharath6365.pricing.engine.entities.PricingRule;
import com.bharath6365.pricing.server.models.Rule;
import org.springframework.stereotype.Component;

@Component
public class PricingUtil {
    public static PricingRule getPricingRuleFromDbRule(Rule ruleModel) {
        return PricingRule.builder()
                .ruleType(ruleModel.getRuleType())
                .action(ruleModel.getAction())
                .condition(ruleModel.getCondition())
                .isTerminal(ruleModel.isTerminal())
                .build();
    }
}

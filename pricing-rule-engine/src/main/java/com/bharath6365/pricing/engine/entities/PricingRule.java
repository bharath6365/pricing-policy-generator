package com.bharath6365.pricing.engine.entities;

import com.bharath6365.pricing.common.entities.RuleType;
import com.bharath6365.pricing.engine.parser.DSLParser;
import com.bharath6365.pricing.engine.parser.MvelParser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class PricingRule {
    private String name;

    private RuleType ruleType;

    private String condition;

    private String action;

    private MvelParser mvelParser;

    private DSLParser dslParser;

    private boolean isTerminal;

}

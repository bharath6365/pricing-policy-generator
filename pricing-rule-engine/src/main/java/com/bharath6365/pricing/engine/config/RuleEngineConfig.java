package com.bharath6365.pricing.engine.config;


import com.bharath6365.pricing.engine.entities.PricingRuleEngine;
import com.bharath6365.pricing.engine.parser.DSLParser;
import com.bharath6365.pricing.engine.parser.MvelParser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bharath6365.pricing.engine.rules.RuleEngineType;

@Configuration
public class RuleEngineConfig {

    @Bean
    public PricingRuleEngine pricingRuleEngine(DSLParser dslParser, MvelParser mvelParser) {
        RuleEngineType ruleEngineType = RuleEngineType.CONSUMER_PRICING;
        int id = 1;
        int version = 1;

        PricingRuleEngine ruleEngine = new PricingRuleEngine(ruleEngineType, id, version);
        ruleEngine.setDslParser(dslParser);
        ruleEngine.setMvelParser(mvelParser);
        return ruleEngine;
    }

}
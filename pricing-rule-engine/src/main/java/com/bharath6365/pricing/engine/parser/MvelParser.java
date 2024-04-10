package com.bharath6365.pricing.engine.parser;

import org.mvel2.MVEL;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

@Component
public class MvelParser {

    // Evaluates a condition expression and returns a boolean result
    public boolean parseCondition(String rule, Map<String, Object> context) {
        try {
            Serializable compiledExpression = MVEL.compileExpression(rule);
            return MVEL.executeExpression(compiledExpression, context, Boolean.class);
        } catch (Exception e) { // Corrected to use 'context'
            System.out.println("Error while evaluating MVEL condition: " + e.getMessage());
            return false;
        }
    }

    // Executes an action expression without expecting a return value
    public boolean executeAction(String action, Map<String, Object> context) {
        try {
            Serializable compiledExpression = MVEL.compileExpression(action);
            MVEL.executeExpression(compiledExpression, context);
            return true;
        } catch (Exception e) {
            System.out.println("Error while executing MVEL action: " + e.getMessage());
            return false;
        }
    }
}

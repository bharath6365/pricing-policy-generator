package com.bharath6365.pricing.engine.parser;

import com.bharath6365.pricing.common.exceptions.DSLException;
import com.bharath6365.pricing.engine.resolver.BankDslResolver;
import com.bharath6365.pricing.engine.resolver.DslResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DSLParser {
    private final Map<String, DslResolver> dslResolvers;

    public DSLParser() {
        this.dslResolvers = new HashMap<>();
        this.dslResolvers.put("bank", new BankDslResolver());
        // Add other resolvers as needed
    }

    // incomingRule -> "$(bank).target_done == true || $(bank).under_maintenance == true"
    public String parseRule(String incomingRule) throws DSLException {
        // Pattern to match expressions like $(bank).target_done
        Pattern pattern = Pattern.compile("\\$\\(([^)]+)\\)\\.([\\w]+)");
        Matcher matcher = pattern.matcher(incomingRule);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String domain = matcher.group(1); // Extracts 'bank' from $(bank)
            String keyword = matcher.group(2); // Extracts 'target_done' from $(bank).target_done

            DslResolver resolver = this.dslResolvers.get(domain);
            if (resolver == null) {
                throw new DSLException("DSL Resolver not found for domain: " + domain);
            }

            Object value = resolver.evaluate(keyword);
            if (value == null) {
                throw new DSLException("Evaluation failed for keyword: " + keyword + " in domain: " + domain);
            }

            // Replacing the whole DSL expression with its evaluated value
            matcher.appendReplacement(sb, Matcher.quoteReplacement(value.toString()));
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}

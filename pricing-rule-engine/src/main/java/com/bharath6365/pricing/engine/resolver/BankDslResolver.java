package com.bharath6365.pricing.engine.resolver;


public class BankDslResolver implements DslResolver {
    private static final String DOMAIN_NAME = "bank";

    @Override
    public String getDomainName() {
        return DOMAIN_NAME;
    }

    @Override
    public Object evaluate(String keyword) throws IllegalArgumentException{
      switch (keyword) {
        case "target_done":
          return false;
          case "under_maintenance":
              return false;
        default:
          throw new IllegalArgumentException("Invalid keyword: " + keyword);
      }
    }
}

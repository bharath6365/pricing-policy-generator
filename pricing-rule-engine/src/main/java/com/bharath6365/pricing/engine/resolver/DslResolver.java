package com.bharath6365.pricing.engine.resolver;

public interface DslResolver {
    String getDomainName();

    Object evaluate(String keyword) throws IllegalArgumentException;

}

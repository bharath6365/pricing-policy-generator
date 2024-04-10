package com.bharath6365.pricing.engine.rules;

import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

abstract public class RuleEngine<E, R, O> {
    private RuleEngineType ruleEngineType;

    private int id;

    private int version;

    abstract public Optional<O> executeRules(E e, List<R> r);


    public RuleEngine(RuleEngineType ruleEngineType, int id, int version) {
        this.ruleEngineType = ruleEngineType;
        this.id = id;
        this.version = version;

    }
}

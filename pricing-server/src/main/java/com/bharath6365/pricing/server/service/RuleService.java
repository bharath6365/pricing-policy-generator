package com.bharath6365.pricing.server.service;

import com.bharath6365.pricing.server.models.Rule;
import com.bharath6365.pricing.server.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleService {

    @Autowired
    private RuleRepository ruleRepository;

    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

}
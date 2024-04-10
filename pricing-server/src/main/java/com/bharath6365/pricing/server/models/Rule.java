package com.bharath6365.pricing.server.models;


import com.bharath6365.pricing.common.entities.RuleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "rules")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rule {
    @Column(name="namespace")
    private String namespace;

    @Column(name="description")
    private String description;

    @Column(name = "condition")
    private String condition;

    @Column(name = "action")
    private String action;

    @Column(name ="rule_type")
    private RuleType ruleType;

    @Id
    @JsonIgnore
    private Long id;

    @Column(name = "is_terminal")
    private boolean isTerminal;


}


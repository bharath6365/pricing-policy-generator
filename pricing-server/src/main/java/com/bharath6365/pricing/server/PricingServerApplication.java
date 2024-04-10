package com.bharath6365.pricing.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bharath6365.pricing", "com.bharath6365.pricing.common"})
public class PricingServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PricingServerApplication.class, args);
    }

}

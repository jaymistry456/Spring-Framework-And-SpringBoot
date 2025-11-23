package com.in28minutes.learn_spring_framework.simpleExamples.currencyConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
    private CurrencyConfigurationService configuration;

    @Autowired
    public CurrencyConfigurationController(CurrencyConfigurationService configuration) {
        this.configuration = configuration;
    }

    @RequestMapping("/currency-configuration")
    public CurrencyConfigurationService getCurrencyConfiguration() {
        return this.configuration;
    }
}

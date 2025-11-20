package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String firstName() {
        return "John";
    }

    @Bean
    public String lastName() {
        return "Doe";
    }

    @Bean
    public Address address() {
        return new Address("Fredericton", "New Brunswick");
    }

    @Bean
    public Person person(String firstName, String lastName, Address address) {
        return new Person(firstName, lastName, address);
    }
}

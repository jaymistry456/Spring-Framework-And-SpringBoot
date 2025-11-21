package com.in28minutes.learn_spring_framework.simpleExamples.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloWorldConfiguration {
    // @Qualifier takes precedence over @Primary

    @Bean
    public String firstName() {
        return "John";
    }

    @Bean
    public String lastName() {
        return "Doe";
    }

    @Bean
    @Primary
    public Address address() {
        return new Address("Fredericton", "New Brunswick");
    }

    @Bean
    @Qualifier("address2Qualifier")
    public Address address2() {
        return new Address("Halifax", "Nova Scotia");
    }

    @Bean
    public Person person(String firstName, String lastName, Address address) {
        return new Person(firstName, lastName, address);
    }

    @Bean(name="person2")
    public Person person2(String firstName, String lastName, @Qualifier("address2Qualifier") Address address2) {
        return new Person(firstName, lastName, address2);
    }
}

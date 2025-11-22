package com.in28minutes.learn_spring_framework.simpleExamples.jakartaAnnotations;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Named    // Replacement for @Component
class DataClass {
    public void printData() {
        System.out.println("Inside Data Class");
    }
}

@Named    // Replacement for @Component
class BusinessClass {
    DataClass dataClass;

    @Inject    // Replacement for @Autowired
    public BusinessClass(DataClass dataClass) {
        this.dataClass = dataClass;
    }

    public void printBusiness() {
        System.out.println("Inside Business Class");
        System.out.println("Calling Data Class...");
        this.dataClass.printData();
    }
}

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.simpleExamples.jakartaAnnotations")
public class JakartaAnnotations {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JakartaAnnotations.class)) {
            context.getBean(BusinessClass.class).printBusiness();
        }
    }
}

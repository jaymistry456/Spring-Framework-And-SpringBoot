package com.in28minutes.learn_spring_framework.simpleExamples.lazyInitialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class A {

}

@Component
@Lazy
class B {
    private A a;

    @Autowired
    public B(A a) {
        this.a = a;
    }
}

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.simpleExamples.lazyInitialization")
public class LazyInitialization {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext((LazyInitialization.class))) {
            System.out.println("Context Initialization Completed");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}

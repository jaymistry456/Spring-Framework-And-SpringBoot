package com.in28minutes.learn_spring_framework.simpleExamples.helloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean("firstName"));
            System.out.println(context.getBean("lastName"));
            System.out.println(context.getBean("address"));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2"));
        }
    }
}

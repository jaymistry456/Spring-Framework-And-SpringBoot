package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        System.out.println(context.getBean("firstName"));
        System.out.println(context.getBean("lastName"));
        System.out.println(context.getBean("address"));
        System.out.println(context.getBean("person"));
    }
}

package com.in28minutes.learn_spring_framework.simpleExamples.xmlConfiguration;

import com.in28minutes.learn_spring_framework.app03.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XMLConfiguration {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean("firstName"));
            System.out.println(context.getBean("lastName"));
            context.getBean(GameRunner.class).run();
        }
    }
}

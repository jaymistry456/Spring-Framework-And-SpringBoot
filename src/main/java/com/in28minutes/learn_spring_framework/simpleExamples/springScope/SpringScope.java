package com.in28minutes.learn_spring_framework.simpleExamples.springScope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(value = "singleton")    // Optional
class SingletonClass {

}

@Component
//@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(value = "prototype")
class PrototypeClass {

}

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.simpleExamples.springScope")
public class SpringScope {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringScope.class)) {
            // Only One Singleton class object is created per Spring IOC Container
            System.out.println("Accessing SingletonClass");
            System.out.println(context.getBean(SingletonClass.class));
            System.out.println(context.getBean(SingletonClass.class));
            System.out.println(context.getBean(SingletonClass.class));
            System.out.println(context.getBean(SingletonClass.class));
            System.out.println(context.getBean(SingletonClass.class));
            System.out.println(context.getBean(SingletonClass.class));
            System.out.println(context.getBean(SingletonClass.class));

            // Many Prototype class objects are created per Spring IOC Container
            System.out.println("Accessing PrototypeClass");
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

        }
    }
}

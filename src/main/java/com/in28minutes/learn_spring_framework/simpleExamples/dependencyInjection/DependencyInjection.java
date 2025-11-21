package com.in28minutes.learn_spring_framework.simpleExamples.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Component
class BusinessClass {
//    // 1. Field Injection
//    @Autowired
//    Dependency1 dependency1;
//
//    @Autowired
//    Dependency2 dependency2;
//
//    @Override
//    public String toString() {
//        return "BusinessClass{" +
//                "dependency1=" + dependency1 +
//                ", dependency2=" + dependency2 +
//                '}';
//    }

//    // 2. Setter Injection
//    Dependency1 dependency1;
//    Dependency2 dependency2;
//
//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        this.dependency2 = dependency2;
//    }

    // 3. Constructor Injection - Recommended
    Dependency1 dependency1;
    Dependency2 dependency2;

    @Autowired    // Annotation is optional
    public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }
}

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.simpleExamples.dependencyInjection")
public class DependencyInjection {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjection.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}

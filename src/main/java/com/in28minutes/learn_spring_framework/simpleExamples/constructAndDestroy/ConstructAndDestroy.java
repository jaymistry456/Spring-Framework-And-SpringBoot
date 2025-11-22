package com.in28minutes.learn_spring_framework.simpleExamples.constructAndDestroy;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class DependencyClass {
    public void printDependency() {
        System.out.println("Inside printDependency");
    }
}

@Component
class BusinessClass {
    DependencyClass dependencyClass;

    @Autowired
    public BusinessClass(DependencyClass dependencyClass) {
        System.out.println("Inside BusinessClass Constructor");
        this.dependencyClass = dependencyClass;
        System.out.println("DependencyClass Initialization Completed");
    }

    @PostConstruct
    public void postContructCall() {
        System.out.println("PostContruct");
        this.dependencyClass.printDependency();
    }

    @PreDestroy
    public void preDestroyCall() {
        System.out.println("PreDestroy");
        System.out.println("Cleanup...");
    }
}

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.simpleExamples.constructAndDestroy")
public class ConstructAndDestroy {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConstructAndDestroy.class)) {
            System.out.println(context.getBean(BusinessClass.class));
        }
    }
}

package com.in28minutes.learn_spring_framework.simpleExamples.dependencyInjection2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

interface DataService {
    int[] retrieveData();
}

@Repository
@Qualifier("MySQLQualifier")
class MySQLDataService implements DataService {
    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5, 6, 7};
    }
}

@Repository
@Primary
class MongoDBDataService implements DataService {
    public int[] retrieveData() {
        return new int[]{11, 22, 33, 44, 55, 66, 77};
    }
}

@Service
class BusinessCalculationService {
    DataService dataService;

    @Autowired
    public BusinessCalculationService(@Qualifier("MySQLQualifier") DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(this.dataService.retrieveData()).max().orElse(0);
    }
}

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.simpleExamples.dependencyInjection2")
public class DependencyInjection2 {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjection2.class)) {
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}

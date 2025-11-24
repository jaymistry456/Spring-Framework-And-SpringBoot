package com.in28minutes.learn_spring_framework.simpleExamples.h2DatabaseJPA.jpa;

import com.in28minutes.learn_spring_framework.simpleExamples.h2DatabaseJPA.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJPACommandLineRunner implements CommandLineRunner {
    private CourseJPARepository repository;

    @Autowired
    public CourseJPACommandLineRunner(CourseJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Spring and Springboot", "in28minutes"));
        repository.insert(new Course(2, "AngularJS", "Maximillian"));
        repository.insert(new Course(3, "Java", "Telusko"));

        repository.deleteById(3);

        System.out.println(repository.findById(1));
        System.out.println(repository.findById(2));
    }
}

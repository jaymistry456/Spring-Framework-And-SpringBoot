package com.in28minutes.learn_spring_framework.simpleExamples.h2DatabaseJPARepository.jpa;

import com.in28minutes.learn_spring_framework.simpleExamples.h2DatabaseJPARepository.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJPARepositoryCommandLineRunner implements CommandLineRunner {
    private CourseJPARepository repository;

    @Autowired
    public CourseJPARepositoryCommandLineRunner(CourseJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1L, "Spring and Springboot", "in28minutes"));
        repository.save(new Course(2L, "AngularJS", "Maximillian"));
        repository.save(new Course(3L, "Java", "Telusko"));

        repository.deleteById(3L);

        System.out.println(repository.findById(1L));
        System.out.println(repository.findById(2L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByName("Angularjs"));
        System.out.println(repository.findByName("AngularJS"));

        System.out.println(repository.findByAuthor("IN28Minutes"));
        System.out.println(repository.findByAuthor("in28minutes"));
    }
}

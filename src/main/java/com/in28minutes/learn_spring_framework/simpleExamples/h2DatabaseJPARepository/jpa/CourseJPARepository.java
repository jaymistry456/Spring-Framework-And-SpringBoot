package com.in28minutes.learn_spring_framework.simpleExamples.h2DatabaseJPARepository.jpa;

import com.in28minutes.learn_spring_framework.simpleExamples.h2DatabaseJPARepository.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseJPARepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
    List<Course> findByAuthor(String name);
}

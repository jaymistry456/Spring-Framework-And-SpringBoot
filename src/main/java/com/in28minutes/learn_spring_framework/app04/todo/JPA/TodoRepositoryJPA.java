package com.in28minutes.learn_spring_framework.app04.todo.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepositoryJPA extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUsername(String username);
}

package com.in28minutes.learn_spring_framework.app04.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "in28minutes", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "Telusko", "Learn Java", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "Maximillian", "Learn Angular", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findTodosByUsername(String username) {
        return todos.stream()
                .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
                .toList();
    }

    public void addNewTodo(String username, String description, LocalDate targetDate, boolean done) {
        todos.add(new Todo(++todosCount, username, description, targetDate, done));
    }
}

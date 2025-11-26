package com.in28minutes.learn_spring_framework.app04.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    @Autowired
    private TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listTodos(ModelMap model) {
        List<Todo> todos = todoService.findTodosByUsername((String) model.get("name"));
        model.put("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addTodo(ModelMap model) {
        Todo todo = new Todo(0, (String) model.get("name"), "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "addTodo";
    }

//    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
//    public String processNewTodo(@RequestParam String description, ModelMap model) {
//        todoService.addNewTodo((String) model.get("name"), description, LocalDate.now().plusYears(1), false);
//        return "redirect:list-todos";
//    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String processNewTodo(ModelMap model, Todo todo) {
        todoService.addNewTodo((String) model.get("name"), todo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}

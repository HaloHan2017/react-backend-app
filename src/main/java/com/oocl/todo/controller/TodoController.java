package com.oocl.todo.controller;

import com.oocl.todo.model.Todo;
import com.oocl.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*")
@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @GetMapping
    public List<Todo> getTodoList() {
        return null;
    }

    @GetMapping("/{id}")
    public List<Todo> getTodoById(@PathVariable Integer id) {
        return null;
    }

    @PutMapping("/{id}")
    public Todo updateTodoById(@PathVariable Integer id,@RequestBody Todo todo) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Integer id) {
    }
}

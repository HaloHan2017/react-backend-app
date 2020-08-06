package com.oocl.todo.controller;

import com.oocl.todo.model.Todo;
import com.oocl.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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
        return todoService.getTodoList();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Integer id) {
        return todoService.getTodoById(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodoById(@PathVariable Integer id, @RequestBody Todo todo) {
        return todoService.updateTodoById(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Integer id) {
        todoService.deleteTodoById(id);
    }
}

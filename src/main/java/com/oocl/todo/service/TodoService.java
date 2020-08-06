package com.oocl.todo.service;

import com.oocl.todo.model.Todo;
import com.oocl.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public void deleteTodoById(int id) {
        todoRepository.deleteById(id);
    }

    public Todo updateTodoById(Integer id, Todo updateTodo) {
        Todo findTodoById = todoRepository.findById(id).orElse(null);
        if(Objects.isNull(findTodoById)){
            return null;
        }
        updateTodo.setId(id);
        return todoRepository.save(updateTodo);
    }
}

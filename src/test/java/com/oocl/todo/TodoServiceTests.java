package com.oocl.todo;

import com.oocl.todo.model.Todo;
import com.oocl.todo.repository.TodoRepository;
import com.oocl.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class TodoServiceTests {
    @InjectMocks
    private TodoService todoService;
    @Mock
    private TodoRepository todoRepository;

    @Test
    void should_return_todo_when_add_todo_given_todo() {
        Todo addTodo = new Todo("hahahhaha");
        given(todoRepository.save(any())).willReturn(new Todo(1, "hahahhaha", false));
        Todo todo = todoService.addTodo(addTodo);
        assertNotNull(todo);
        assertEquals(addTodo.getContent(), todo.getContent());
    }

    @Test
    void should_return_todo_list_when_get_todo_list_given_nothing() {
        given(todoRepository.findAll()).willReturn(Collections.emptyList());
        List<Todo> todoList = todoService.getTodoList();
        assertEquals(0, todoList.size());
    }
}

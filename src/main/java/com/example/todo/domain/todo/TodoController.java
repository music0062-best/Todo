package com.example.todo.domain.todo;

import com.example.todo.domain.todo.dto.TodoCreateRequest;
import com.example.todo.domain.todo.dto.TodoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<Long> createTodo(@Valid @RequestBody TodoCreateRequest request) {
        Long id = todoService.createTodo(request);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getTodos() {
        return ResponseEntity.ok(todoService.findAll());
    }
}

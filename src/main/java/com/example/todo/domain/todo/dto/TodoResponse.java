package com.example.todo.domain.todo.dto;

import com.example.todo.domain.todo.Todo;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class TodoResponse {

    private final Long id;
    private final String title;
    private final boolean done;
    private final LocalDateTime createdAt;
    private final List<String> tags;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.done = todo.isDone();
        this.createdAt = todo.getCreatedAt();
        this.tags = todo.getTodoTags().stream()
                .map(todoTag -> todoTag.getTag().getName())
                .toList();
    }
}
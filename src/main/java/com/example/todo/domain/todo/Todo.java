package com.example.todo.domain.todo;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean done;

    private LocalDateTime createdAt;

    @Builder
    public Todo(String title) {
        this.title = title;
        this.done = false;
        this.createdAt = LocalDateTime.now();
    }
}
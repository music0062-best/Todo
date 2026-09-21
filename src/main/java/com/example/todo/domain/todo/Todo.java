package com.example.todo.domain.todo;

import com.example.todo.domain.tag.Tag;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

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

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TodoTag> todoTags = new ArrayList<>();

    @Builder
    public Todo(String title) {
        this.title = title;
        this.done = false;
        this.createdAt = LocalDateTime.now();
    }

    public void addTag(Tag tag) {
        TodoTag todoTag = TodoTag.builder()
                .todo(this)
                .tag(tag)
                .build();
        this.todoTags.add(todoTag);
    }
}
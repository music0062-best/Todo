package com.example.todo.domain.todo;

import com.example.todo.domain.tag.Tag;
import jakarta.persistence.*;
import lombok.Builder;

public class TodoTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Builder
    public TodoTag(Todo todo, Tag tag) {
        this.todo = todo;
        this.tag = tag;
    }
}

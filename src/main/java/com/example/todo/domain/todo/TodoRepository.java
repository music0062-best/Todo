package com.example.todo.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public  interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByTodoTags_Tag_Name(String tagName);
}

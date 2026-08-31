package com.example.todo.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoTagRepository extends JpaRepository<TodoTag, Long> {
}

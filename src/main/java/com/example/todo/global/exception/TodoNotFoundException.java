package com.example.todo.global.exception;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(Long id) {
        super("존재하지 않는 Todo입니다. id=" + id);
    }
}
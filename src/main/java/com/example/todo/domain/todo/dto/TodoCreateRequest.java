package com.example.todo.domain.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class TodoCreateRequest {

    @NotBlank
    private String title;
}

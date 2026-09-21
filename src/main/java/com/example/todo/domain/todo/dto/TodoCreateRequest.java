package com.example.todo.domain.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import java.util.List;

@Getter
public class TodoCreateRequest {

    @NotBlank
    private String title;

    private List<String> tagNames; // ex: ["공부", "운동", "요리"]
}

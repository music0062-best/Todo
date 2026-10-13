package com.example.todo.domain.todo;

import com.example.todo.domain.tag.Tag;
import com.example.todo.domain.tag.TagRepository;
import com.example.todo.domain.todo.dto.TodoCreateRequest;
import com.example.todo.domain.todo.dto.TodoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;
    private final TagRepository tagRepository;

    @Transactional
    public Long createTodo(TodoCreateRequest request) {
        Todo todo = Todo.builder()
                .title(request.getTitle())
                .build();

        if (request.getTagNames() != null) {
            for (String tagName : request.getTagNames()) {

                Tag tag = tagRepository.findByName(tagName)
                        .orElseGet(() -> tagRepository.save(Tag.builder().name(tagName).build()));
                todo.addTag(tag);
            }
        }

        return todoRepository.save(todo).getId();
    }

    public List<TodoResponse> findAll() {
        return todoRepository.findAll().stream()
                .map(TodoResponse::new)
                .toList();
    }

    public List<TodoResponse> findByTag(String tagName) {
        return todoRepository.findByTodoTags_Tag_Name(tagName).stream()
                .map(TodoResponse::new)
                .toList();
    }
}
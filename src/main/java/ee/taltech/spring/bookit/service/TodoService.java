package ee.taltech.spring.bookit.service;

import ee.taltech.spring.bookit.domain.Todo;

import java.util.List;

public interface TodoService {

    Todo getTodo(long id);

    List<Todo> getAllTodos();

    Todo addTodo(Todo todo);

    void saveAll(List<Todo> todo);
}

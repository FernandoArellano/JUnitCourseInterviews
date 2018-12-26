package com.in28minutes.junit.data.api;

import com.in28minutes.junit.helper.service.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
    }

    public void deleteTodo(String todo) {

    }
}

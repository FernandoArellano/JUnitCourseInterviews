package com.in28minutes.junit.helper.service;

import java.util.List;

// External Service - Lets say this comes from WunderList
public interface TodoService {

    public List<String> retrieveTodos(String user);

    public void deleteTodo(String todo);

}

package com.in28minutes.junit.business;

import com.in28minutes.junit.data.api.TodoServiceStub;
import com.in28minutes.junit.helper.business.TodoBusinessImpl;
import com.in28minutes.junit.helper.service.TodoService;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class TodoBusinessImplStubTest {

    @Test
    public void test(){
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> list = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, list.size());
    }
}

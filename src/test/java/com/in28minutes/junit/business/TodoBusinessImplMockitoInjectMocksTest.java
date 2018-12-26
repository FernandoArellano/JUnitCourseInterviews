package com.in28minutes.junit.business;

import com.in28minutes.junit.helper.business.TodoBusinessImpl;
import com.in28minutes.junit.helper.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {

    @Mock
    TodoService todoServiceMock;
    //creates and let it available to use

    @InjectMocks
    TodoBusinessImpl todoBusiness;
    //will create a instance of todoBusiness, dependencies are fullfilled with the @Mock instance vars, in this case todoServiceMock only

    @Test
    public void test(){
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> list = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, list.size());
    }

    @Test
    public void deleteTodo(){
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //verify will check if a specific method method is called 1,2 or 10 doesnt matter
        verify(todoServiceMock).deleteTodo("Learn to Dance");

        //verify that the method is never called
        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");

        //verify will check if a specific method method is called 1 time only
        verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
    }
}

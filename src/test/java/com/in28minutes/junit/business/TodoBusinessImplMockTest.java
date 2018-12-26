package com.in28minutes.junit.business;

import com.in28minutes.junit.data.api.TodoServiceStub;
import com.in28minutes.junit.helper.business.TodoBusinessImpl;
import com.in28minutes.junit.helper.service.TodoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void test(){
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
        List<String> list = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, list.size());
    }

    @Test
    public void deleteTodo(){
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //verify will check if a specific method method is called 1,2 or 10 doesnt matter
        verify(todoServiceMock).deleteTodo("Learn to Dance");

        //verify that the method is never called
        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");

        //verify will check if a specific method method is called 1 time only
        verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
    }

    @Test
    public void deleteTodoCaptureArgument(){
        //Declare argument captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        //define argument captor on specific method call
        //capture arcument

        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
    }
}

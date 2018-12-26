package com.in28minutes.junit.business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void test(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);

        assertEquals(2, listMock.size());
    }

    @Test
    public void returnMultipleValues(){
        List listMock = mock(List.class);
        //first time it calls the size method of the mock will return 2, then the second and rest will return 3
        when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void getMethod(){
        List listMock = mock(List.class);

        when(listMock.get(0)).thenReturn("In28Minutes");
        assertEquals("In28Minutes", listMock.get(0));
        //will return null cause get(1) is not configured
        //assertEquals("In28Minutes", listMock.get(1));

        //any int received will return FerCourse
        when(listMock.get(anyInt())).thenReturn("FerCourse");
        assertEquals("FerCourse", listMock.get(10));
    }

    @Test(expected = RuntimeException.class)
    public void throwException(){
        List listMock = mock(List.class);

        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Some error"));
        listMock.get(10);
    }
}

package com.in28minutes.junit.mockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void test(){
        List arrayListMock = mock(ArrayList.class);
        assertEquals(0, arrayListMock.size());

        //mocks return default value
        stub(arrayListMock.size()).toReturn(5);
        //its not affected, its a mock which already is defined to return 5
        arrayListMock.add(5);
        assertEquals(5, arrayListMock.size());
    }

    @Test
    public void testSpy(){
        List arrayListMock = spy(ArrayList.class);
        assertEquals(0, arrayListMock.size());
        //real arraylist funcionality change size to 1
        arrayListMock.add("Dummy");
        assertEquals(1, arrayListMock.size());
        verify(arrayListMock).add("Dummy");
        verify(arrayListMock, never()).clear();

        //overwrite method so size will now return always 5, rest of methods keep working normally
        stub(arrayListMock.size()).toReturn(5);
        assertEquals(5, arrayListMock.size());
    }


}

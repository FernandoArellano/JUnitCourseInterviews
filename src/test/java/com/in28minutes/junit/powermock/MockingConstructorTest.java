package com.in28minutes.junit.powermock;

import com.in28minutes.junit.helper.powermock.Dependency;
import com.in28minutes.junit.helper.powermock.SystemUnderTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class MockingConstructorTest {

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Mock
    ArrayList mockList;

    @Test
    public void test() throws Exception{
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);

        when(mockList.size()).thenReturn(5);

        int size = systemUnderTest.methodUsingAnArrayListConstructor();

        assertEquals(5, size);
    }
}

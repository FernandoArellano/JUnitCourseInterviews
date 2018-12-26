package com.in28minutes.junit.powermock;

import com.in28minutes.junit.helper.powermock.Dependency;
import com.in28minutes.junit.helper.powermock.SystemUnderTest;
import com.in28minutes.junit.helper.powermock.UtilityClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTest {

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void test(){

        List<Integer> list = Arrays.asList(1,2,3);

        when(dependency.retrieveAllStats()).thenReturn(list);

        PowerMockito.mockStatic(UtilityClass.class);

        when(UtilityClass.staticMethod(6)).thenReturn(150);

        int result = systemUnderTest.methodCallingAStaticMethod();

        assertEquals(150, result);
    }
}

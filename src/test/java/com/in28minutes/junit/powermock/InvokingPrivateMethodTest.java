package com.in28minutes.junit.powermock;

import com.in28minutes.junit.helper.powermock.Dependency;
import com.in28minutes.junit.helper.powermock.SystemUnderTest;
import com.in28minutes.junit.helper.powermock.UtilityClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class InvokingPrivateMethodTest {

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void test() throws Exception{

        List<Integer> list = Arrays.asList(1,2,3);

        when(dependency.retrieveAllStats()).thenReturn(list);

        long result = Whitebox.invokeMethod(systemUnderTest,"privateMethodUnderTest");

        assertEquals(6, result);
    }
}

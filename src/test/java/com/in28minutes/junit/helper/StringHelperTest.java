package com.in28minutes.junit.helper;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {

    @Test
    public void test(){
        StringHelper helper = new StringHelper();
        //assertEquals(expected value, actual value);
        assertEquals("BC", helper.truncateAInFirst2Positions("AABC") );
    }

}

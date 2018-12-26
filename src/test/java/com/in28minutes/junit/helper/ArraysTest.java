package com.in28minutes.junit.helper;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;


public class ArraysTest {

    @Test
    public void arrayTest(){
        int [] numbers = new int[]{10,2,5,9,3};
        int [] expected = new int[]{2,3,5,9,10};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test(expected = NullPointerException.class)
    public void arrayNullTest(){
        int [] numbers = null;
        Arrays.sort(numbers);
    }
}

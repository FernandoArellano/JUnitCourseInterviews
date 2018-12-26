package com.in28minutes.junit.helper;

import org.junit.*;

public class QuickBeforeAfterTest {

    @Before
    public void init(){
        System.out.println("Before");
    }

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @After
    public void after(){
        System.out.println("After");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
}

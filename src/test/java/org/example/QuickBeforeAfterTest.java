package org.example;

import org.junit.*;

import static org.junit.Assert.*;
public class QuickBeforeAfterTest {


    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @Before
    public void setup(){
        System.out.println("before test");
    }

    @Test
    public void test1() {
        System.out.println("Test 1 executed");
    }

    @Test
    public void test2() {
        System.out.println("Test 2 executed");
    }

    @After
    public void teardown(){
        System.out.println("after test");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }
}
package org.example;

import org.junit.Test;

import java.util.Arrays;

public class ArrayCompareTest {

    @Test
    public void testArrayCompare() {
        int[] numbers = {12,4,3,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assert Arrays.equals(expected, numbers);
    }

    @Test(expected = NullPointerException.class)
    public void testArrayCompare_Null() {
        int[] numbers = null;
        Arrays.sort(numbers);
    }

    @Test(timeout = 100)
    public void testArrayCompare_performance() {
        int array[] = {12,23,4};
        for(int i=1; i<1000000; i++){
            array[0]= i;
            Arrays.sort(array);

        }
    }

}

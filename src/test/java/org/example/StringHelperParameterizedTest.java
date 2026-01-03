package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

    StringHelper helper = new StringHelper();

    private String input;
    private String expectedOutput;

    public StringHelperParameterizedTest(String input, String expectedOutput) {
        super();
        this.input = input;
        this.expectedOutput = expectedOutput;
    }


    @Parameterized.Parameters
    public static Collection<String[]> testConditions() {
        String expectedOutputs[][] = {{"AACD", "CD"},{"ACD", "CD"}};
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void Test(){
        StringHelper helper = new StringHelper();
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
    }

    @Test
    public void testTruncateAInFirst2Positions(){
        StringHelper helper = new StringHelper();
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
    }

}
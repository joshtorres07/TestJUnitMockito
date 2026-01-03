package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringHelperTest {

    StringHelper helper;
    @Before
    public void before() {
        helper = new StringHelper();
    }

    @Test
    public void Test(){
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions(){
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void testAreFirstAndLast2Caratters(){
    boolean actual = helper.areFirstAndLastTwoCharactersTheSame("ABCD");
    assertEquals(false, actual);
    }

    @Test
    public void testAreFirstAndLast2CarattersFalse(){
        boolean actual = helper.areFirstAndLastTwoCharactersTheSame("ABCD");
        assertFalse("Dummy string", actual);
    }

}
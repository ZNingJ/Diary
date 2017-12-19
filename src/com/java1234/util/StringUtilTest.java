package com.java1234.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testIsEmpty() {
        String str = "";
        boolean actual = StringUtil.isEmpty(str);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void testIsNotEmpty() {
        String str = "x";
        boolean actual = StringUtil.isNotEmpty(str);
        boolean expected = true;
        assertEquals(expected, actual);
    }

}

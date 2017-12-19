package com.java1234.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.java1234.util.PropertiesUtil;

public class PropertiesUtilTest {

    @Test
    public void testGetValue1() {
        String actual = PropertiesUtil.getValue("dbUrl");
        String expected = "jdbc:mysql://localhost:3306/db_diary";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetValue2() {
        String actual = PropertiesUtil.getValue("dbUserName");
        String expected = "root";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetValue3() {
        String actual = PropertiesUtil.getValue("dbPassword");
        String expected = "123456";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetValue4() {
        String actual = PropertiesUtil.getValue("jdbcName");
        String expected = "com.mysql.jdbc.Driver";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetValue5() {
        String actual = PropertiesUtil.getValue("pageSize");
        String expected = "4";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetValue6() {
        String actual = PropertiesUtil.getValue("imageFile");
        String expected = "userImages/";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetValue7() {
        String actual = PropertiesUtil.getValue("imagePath");
        String expected = "D:\\Diary\\WebContent\\userImages\\";
        assertEquals(expected, actual);
    }


}

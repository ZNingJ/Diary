package com.java1234.test;

import com.java1234.util.DateUtil;
import org.junit.Test;

import java.util.Date;

public class DateUtilTest {

    @Test
    public void testFormatDate() {
        Date date = new Date();
        String format = "yyyy-MM-dd HH:mm:ss";
        String actual = DateUtil.formatDate(date, format);
        System.out.println(actual);
    }

    @Test
    public void testFormatString() throws Exception {
        String str = "2017-02-14 08:03:30";
        String format = "yyyy-MM-dd HH:mm:ss";
        Date actual = DateUtil.formatString(str, format);
        System.out.println(actual);
    }

    @Test
    public void testGetCurrentDateStr() throws Exception {

        String actual = DateUtil.getCurrentDateStr();
        System.out.println(actual);

    }

}

package com.java1234.test;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import com.java1234.util.MD5Util;

public class MD5UtilTest {

    @Test
    public void testEncoderPwdByMd5() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String actual = MD5Util.EncoderPwdByMd5("123456");
        String expected = "4QrcOUm6Wau+VuBX8g+IPg==";
        assertEquals(expected, actual);
    }

}

package com.java1234.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.java1234.util.DbUtil;

public class DbUtilTest {
    private DbUtil dbUtil;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        dbUtil = new DbUtil();
    }

    @Test
    public void testGetCon() {
        try {
            con = dbUtil.getCon();
            System.out.println("���ݿ����ӳɹ�");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("���ݿ�����ʧ��");
        }
    }

    @Test
    public void testCloseCon() throws Exception {
        dbUtil.closeCon(con);
        System.out.println("���ݿ����ӹر�");
    }

}

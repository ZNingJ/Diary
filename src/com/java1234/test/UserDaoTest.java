package com.java1234.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.java1234.dao.UserDao;
import com.java1234.model.User;
import com.java1234.util.DbUtil;

public class UserDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLogin() throws Exception {
        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getCon();
        String userName = "java1234";
        String password = "123456";
        User user = new User(userName, password);
        UserDao userDao = new UserDao();
        User actual = userDao.login(con, user);
        System.out.println(actual);
        String expected = "User [userId=1, userName=java1234, password=4QrcOUm6Wau+VuBX8g+IPg==, nickName=苦逼屌丝, imageName=userImages/20140113081010.jpg, mood=生活是一种态度。]";
        assertEquals(expected.length(), actual.toString().length());
    }

    @Test
    public void testUserUpdate() {
        fail("Not yet implemented");
    }

}

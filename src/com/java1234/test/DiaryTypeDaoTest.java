package com.java1234.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java1234.dao.DiaryTypeDao;
import com.java1234.model.DiaryType;
import com.java1234.util.DbUtil;

public class DiaryTypeDaoTest {
    private DiaryTypeDao diaryTypeDao;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        DbUtil dbUtil = new DbUtil();
        con = dbUtil.getCon();
        diaryTypeDao = new DiaryTypeDao();
    }

    @Test
    public void testDiaryTypeCountList() throws Exception {
        List<DiaryType> actual = diaryTypeDao.diaryTypeCountList(con);
        String expected = "[DiaryType [diaryTypeId=6, typeName=AABB, diaryCount=0], DiaryType [diaryTypeId=4, typeName=人生感叹, diaryCount=8], DiaryType [diaryTypeId=3, typeName=学习类, diaryCount=3], DiaryType [diaryTypeId=1, typeName=工作类, diaryCount=10], DiaryType [diaryTypeId=7, typeName=是, diaryCount=0], DiaryType [diaryTypeId=5, typeName=测试, diaryCount=0], DiaryType [diaryTypeId=2, typeName=生活类, diaryCount=6]]";
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testDiaryTypeList() throws Exception {
        List<DiaryType> actual = diaryTypeDao.diaryTypeList(con);
        String expected = "[DiaryType [diaryTypeId=1, typeName=工作类, diaryCount=0], DiaryType [diaryTypeId=2, typeName=生活类, diaryCount=0], DiaryType [diaryTypeId=3, typeName=学习类, diaryCount=0], DiaryType [diaryTypeId=4, typeName=人生感叹, diaryCount=0], DiaryType [diaryTypeId=5, typeName=测试, diaryCount=0], DiaryType [diaryTypeId=6, typeName=AABB, diaryCount=0], DiaryType [diaryTypeId=7, typeName=是, diaryCount=0]]";
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testDiaryTypeAdd() {
        fail("Not yet implemented");
    }

    @Test
    public void testDiaryTypeUpdate() {
        fail("Not yet implemented");
    }

    @Test
    public void testDiaryTypeShow() {
        fail("Not yet implemented");
    }

    @Test
    public void testDiaryTypeDelete() {
        fail("Not yet implemented");
    }

}

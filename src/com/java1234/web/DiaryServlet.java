package com.java1234.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java1234.dao.DiaryDao;
import com.java1234.model.Diary;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

/**
 * ��������ռǵ�����
 *
 * @author F1232170
 */
public class DiaryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    DbUtil dbUtil = new DbUtil();
    DiaryDao diaryDao = new DiaryDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("show".equals(action)) {
            diaryShow(request, response);
        } else if ("preSave".equals(action)) {
            diaryPreSave(request, response);
        } else if ("save".equals(action)) {
            diarySave(request, response);
        } else if ("delete".equals(action)) {
            diaryDelete(request, response);
        }
    }

    //�ռ���ʾ
    private void diaryShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String diaryId = request.getParameter("diaryId");
        Connection con = null;
        try {
            con = dbUtil.getCon();
            Diary diary = diaryDao.diaryShow(con, diaryId);
            request.setAttribute("diary", diary);
            request.setAttribute("mainPage", "diary/diaryShow.jsp");
            request.getRequestDispatcher("mainTemp.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //д�ռ�
    private void diaryPreSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String diaryId = request.getParameter("diaryId");
        Connection con = null;
        try {
            if (StringUtil.isNotEmpty(diaryId)) {
                con = dbUtil.getCon();
                Diary diary = diaryDao.diaryShow(con, diaryId);  //ͨ��diaryId����ָ�����ռ���Ϣ
                request.setAttribute("diary", diary);   //�����ҵ����ռ���Ϣ����request
            }
            request.setAttribute("mainPage", "diary/diarySave.jsp"); //����mainPage��diary/diarySave.jsp�����jsp����ʹ��diary
            request.getRequestDispatcher("mainTemp.jsp").forward(request, response); //�ڲ�ת����mainTemp.jsp�и�jsp���а���diary/diarySave.jsp
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    //�ռǱ���
    private void diarySave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String typeId = request.getParameter("typeId");
        String diaryId = request.getParameter("diaryId");

        Diary diary = new Diary(title, content, Integer.parseInt(typeId));
        if (StringUtil.isNotEmpty(diaryId)) {
            diary.setDiaryId(Integer.parseInt(diaryId));
        }
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int saveNums;
            if (StringUtil.isNotEmpty(diaryId)) {
                saveNums = diaryDao.diaryUpdate(con, diary);
            } else {
                saveNums = diaryDao.diaryAdd(con, diary);
            }
            if (saveNums > 0) {
                request.getRequestDispatcher("main?all=true").forward(request, response);
            } else {
                request.setAttribute("diary", diary);
                request.setAttribute("error", "����ʧ��");
                request.setAttribute("mainPage", "diary/diarySave.jsp");
                request.getRequestDispatcher("mainTemp.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //�ռ�ɾ��
    private void diaryDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String diaryId = request.getParameter("diaryId");
        Connection con = null;
        try {
            con = dbUtil.getCon();
            diaryDao.diaryDelete(con, diaryId);
            request.getRequestDispatcher("main?all=true").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

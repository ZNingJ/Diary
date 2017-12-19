package com.java1234.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java1234.dao.UserDao;
import com.java1234.model.User;
import com.java1234.util.DbUtil;

/**
 * 处理登录的请求
 *
 * @author F1232170
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    DbUtil dbUtil = new DbUtil();
    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    //登录
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String userName = request.getParameter("userName");                                            //从request对象获得带过来的数据
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        Connection con = null;
        try {
            con = dbUtil.getCon();
            User user = new User(userName, password);                                                    //将request对象带过来的数据，实例化为模型对象
            User currentUser = userDao.login(con, user);                                                //用这这个模型对象从数据库查找
            if (currentUser == null) {
                request.setAttribute("user", user);
                request.setAttribute("error", "用户名或密码错误！");
                request.getRequestDispatcher("login.jsp").forward(request, response);                //如果登录失败，转发到login.jsp
            } else {
                if ("remember-me".equals(remember)) {
                    rememberMe(userName, password, response);
                }
                session.setAttribute("currentUser", currentUser);
                request.getRequestDispatcher("main").forward(request, response);                    //登录成功，请求MainServlet
            }
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

    //记住用户名和密码Cookies 功能
    private void rememberMe(String userName, String password, HttpServletResponse response) {
        Cookie user = new Cookie("user", userName + "-" + password);
        user.setMaxAge(1 * 60 * 60 * 24 * 7);
        response.addCookie(user);
    }
}

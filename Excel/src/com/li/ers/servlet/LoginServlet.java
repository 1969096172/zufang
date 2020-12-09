package com.li.ers.servlet;

import com.li.ers.model.Goods;
import com.li.ers.model.User;
import com.li.ers.service.AdminService;
import com.li.ers.service.HomeService;
import com.li.ers.service.LoginSevice;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class LoginServlet extends HttpServlet {
    private LoginSevice loginService = new LoginSevice();
    private AdminService adminService = new AdminService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    //method反射机制调用方法
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String methodName = request.getParameter("method");
        try{
            //利用反射获取方法
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
            //执行相应的方法
            method.setAccessible(true);
            method.invoke(this,request,response);
        } catch (Exception e) {
            // TODO AUTO-generated catch block
            e.printStackTrace();
        }
    }


    protected void getlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

    protected void login_in(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String useraccount = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        if (useraccount.equals("admin")){
            int adminid = loginService.admin_in(useraccount,userpassword);
            List<Goods> goodsList =  adminService.getad0goods();
            HttpSession session = request.getSession();  //通过request获取session
            session.setAttribute("adminid",adminid);
            session.setAttribute("goodsList",goodsList);
            request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
        }else {
            int userid = loginService.login_in(useraccount,userpassword);
            HttpSession session = request.getSession();  //通过request获取session
            session.setAttribute("userid",userid);
            response.sendRedirect("index.jsp");
        }

    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}

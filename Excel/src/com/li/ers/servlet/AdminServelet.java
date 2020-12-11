package com.li.ers.servlet;

import com.li.ers.model.Goods;
import com.li.ers.model.User;
import com.li.ers.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class AdminServelet extends HomeServlet{
    private AdminService adminService = new AdminService();
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
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
    protected void admingoodst (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int goodsid = Integer.parseInt(request.getParameter("thisSGid"));
        int adminid = Integer.parseInt(request.getParameter("adminid"));
        adminService.changegosadis(goodsid,adminid);
        List<Goods> goodsList =  adminService.getad0goods();
        HttpSession session = request.getSession();  //通过request获取session
        session.setAttribute("adminid",adminid);
        session.setAttribute("goodsList",goodsList);
        request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);

    }
    protected void refusegoods (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int goodsid = Integer.parseInt(request.getParameter("thisSGid"));
        int adminid = Integer.parseInt(request.getParameter("adminid"));
        adminService.refusegos(goodsid);
        List<Goods> goodsList =  adminService.getad0goods();
        HttpSession session = request.getSession();  //通过request获取session
        session.setAttribute("adminid",adminid);
        session.setAttribute("goodsList",goodsList);
        request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);

    }
}

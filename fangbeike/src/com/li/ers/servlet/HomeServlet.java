package com.li.ers.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");

        try{
            //利用反射获取方法
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
            //执行相应的方法
            method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            // TODO AUTO-generated catch block
            e.printStackTrace();
        }
    }
    protected void gatfang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
//        介绍名
        String name = request.getParameter("ming");
//        地区
        String ares = request.getParameter("radio1");
//        租赁方式
        String zufangs = request.getParameter("zufangs");
        String classIdStr = request.getParameter("classId");
        String minpicstr = request.getParameter("minpic");
        String maxpicstr = request.getParameter("maxpic");
        double minpic = 0;
        double maxpic = Double.MAX_VALUE;
        if (minpicstr != null) {
            minpic = Double.parseDouble(minpicstr);
        }else if (maxpicstr != null){
            maxpic = Double.parseDouble(maxpicstr);
            if (minpic > maxpic){
                maxpic = Double.MAX_VALUE;
            }
        }
        String housetypestr = request.getParameter("radio2");
        int housetype = 0;
        if (housetypestr != null){
            housetype = Integer.parseInt(housetypestr);
        }


        request.getRequestDispatcher("/WEB-INF/pages/zufang.jsp").forward(request, response);

    }
    protected void gofxiangqing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/fxiangqing.jsp").forward(request, response);

    }
}

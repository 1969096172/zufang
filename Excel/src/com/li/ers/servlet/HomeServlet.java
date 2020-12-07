package com.li.ers.servlet;

import com.li.ers.model.Goods;
import com.li.ers.model.User;
import com.li.ers.service.HomeService;
import com.li.ers.web.CriteriaComputer;
import com.li.ers.web.Page;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class HomeServlet extends HttpServlet {
    private HomeService homeService = new HomeService();
    private Object uri;
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


    protected void getgoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNoStr = request.getParameter("pageNo");
        String minPriceStr = request.getParameter("minPrice");
        String maxPriceStr = request.getParameter("maxPrice");


        int pageNo = 1;
        int minPrice = 0;
        int maxPrice = Integer.MAX_VALUE;

        try {
            pageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {}

        try {
            minPrice = Integer.parseInt(minPriceStr);
        } catch (NumberFormatException e) {}

        try {
            maxPrice = Integer.parseInt(maxPriceStr);
        } catch (NumberFormatException e) {}

        CriteriaComputer criteriaComputer = new CriteriaComputer(minPrice, maxPrice, pageNo);
        Page<Goods> page = homeService.getPage(criteriaComputer);

        request.setAttribute("goodslist", page);
        if (request.getParameter("userid") != null){
            int userid = Integer.parseInt(request.getParameter("userid"));
            request.setAttribute("userid", userid);
            request.getRequestDispatcher("/WEB-INF/pages/secondhandhome.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/WEB-INF/pages/secondhandhome.jsp").forward(request, response);
        }
    }
    protected void getmine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getmine");
        int userid = Integer.parseInt(request.getParameter("useridS"));
        User userS = homeService.getmine(userid);
//        int userID = userS.getUserid();

        HttpSession session = request.getSession();  //通过request获取session
        session.setAttribute("userS",userS);
        request.getRequestDispatcher("/WEB-INF/pages/mine.jsp").forward(request, response);

    }
}

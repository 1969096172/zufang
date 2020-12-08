package com.li.ers.servlet;

import com.li.ers.model.Goods;
import com.li.ers.model.Orders;
import com.li.ers.service.Orderservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class OrderServelet extends HttpServlet {
    Orderservice orderservice = new Orderservice();
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

    protected void ordergoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int userid = Integer.parseInt(request.getParameter("userid"));
        List<Orders> orders = new ArrayList<>();
        List<Orders> orders2 = new ArrayList<>();

        orders = orderservice.getgoodsid(userid);
        orders2 = orderservice.getgoodsid2(userid);

        List<Goods> goods = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();

        goods = orderservice.getgoods0(orders);
        goods2 = orderservice.getgoods02(orders2);

        HttpSession session = request.getSession();  //通过request获取session
        session.setAttribute("goodsM",goods);
        session.setAttribute("goodsM2",goods2);
        request.getRequestDispatcher("/WEB-INF/pages/ordergoods.jsp").forward(request, response);
    }
}

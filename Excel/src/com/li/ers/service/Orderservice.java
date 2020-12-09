package com.li.ers.service;

import com.li.ers.dao.IOrdersDAO;
import com.li.ers.dao.impl.OrderDAO;
import com.li.ers.model.Goods;
import com.li.ers.model.Orders;

import java.util.List;

public class Orderservice {
    private IOrdersDAO ordersDAO = new OrderDAO();
    public List<Orders> getgoodsid(int userid) {
        String sql = "select * from orders where orderstate = 0 and userid = ?";
        List<Orders> orders = ordersDAO.getgoodsid(sql, userid);
        return orders;
    }

    public List<Goods> getgoods0(List<Orders> goods) {
        String sql = "select * from goods where status = 1 and goodsid = ?";
        List<Goods> goodsList = ordersDAO.getgoods0(sql,goods);
        return goodsList;
    }

    public List<Orders> getgoodsid2(int userid) {
        String sql = "select * from orders where orderstate = 1 and userid = ?";
        List<Orders> orders = ordersDAO.getgoodsid(sql, userid);
        return orders;
    }

    public List<Goods> getgoods02(List<Orders> orders2) {
        String sql = "select * from goods where status = 2 and goodsid = ?";
        List<Goods> goodsList = ordersDAO.getgoods0(sql,orders2);
        return goodsList;
    }

    public Orders getuserid(int goodsid) {
        String sql = "select * from orders where goodsid = ?";
        Orders orders = ordersDAO.getuserid(sql,goodsid);
        return orders;
    }

    public void del(int orderid) {
        String sql = "delete from orders where orderid=?";
        ordersDAO.del(sql, orderid);
    }
}

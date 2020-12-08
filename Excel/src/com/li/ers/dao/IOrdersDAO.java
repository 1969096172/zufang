package com.li.ers.dao;

import com.li.ers.model.Goods;
import com.li.ers.model.Orders;

import java.util.List;

public interface IOrdersDAO {

    List<Orders> getgoodsid(String sql, int userid);

    List<Goods> getgoods0(String sql, List<Orders> goods);
}

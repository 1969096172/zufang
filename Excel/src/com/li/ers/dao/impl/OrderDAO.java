package com.li.ers.dao.impl;

import com.li.ers.dao.IOrdersDAO;
import com.li.ers.db.DBershou;
import com.li.ers.model.Goods;
import com.li.ers.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrdersDAO {

    @Override
    public List<Orders> getgoodsid(String sql, int userid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userid);
            resultSet = preparedStatement.executeQuery();
            List<Orders> ordersList = new ArrayList<>();
            while (resultSet.next()){
                Orders orders = new Orders();
                orders.setGoodsid(resultSet.getInt("goodsid"));
                ordersList.add(orders);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return ordersList;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public List<Goods> getgoods0(String sql, List<Orders> goodsid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Goods> goodsList = new ArrayList<>();
        try{
            connection = DBershou.getConnection();
            for (Orders l: goodsid){
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,l.getGoodsid());
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Goods goods1 = new Goods();
                    goods1.setGoodsid(resultSet.getInt("goodsid"));
                    goods1.setGoodsname(resultSet.getString("goodsname"));
                    goods1.setNewprice(resultSet.getDouble("newprice"));
                    goods1.setOldprice(resultSet.getDouble("oldprice"));
                    goods1.setNewkind(resultSet.getString("newkind"));
                    goods1.setStatus(resultSet.getInt("status"));
                    goods1.setGoodurl(resultSet.getString("goodurl"));
                    goods1.setBrand(resultSet.getString("brand"));
                    goods1.setRemark(resultSet.getString("remark"));
                    goods1.setKindid(resultSet.getInt("kindid"));
                    goods1.setAdminid(resultSet.getInt("adminid"));
                    goods1.setUserid(resultSet.getInt("userid"));
                    goodsList.add(goods1);
                }
                resultSet.close();
                preparedStatement.close();
            }
            connection.close();
            return goodsList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public Orders getuserid(String sql, int goodsid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goodsid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Orders orders = new Orders();
                orders.setOrderid(resultSet.getInt("orderid"));
                orders.setUserid(resultSet.getInt("userid"));
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return orders;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public void del(String sql, int orderid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderid);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
    }

    @Override
    public void add(String sql, int userdtid, int goodsid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,0);
            preparedStatement.setInt(2,userdtid);
            preparedStatement.setInt(3,goodsid);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
    }
}

package com.li.ers.dao.impl;

import com.li.ers.dao.IAdminDAO;
import com.li.ers.db.DBershou;
import com.li.ers.model.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements IAdminDAO {

    @Override
    public List<Goods> getad0goods(String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            List<Goods> goodsList = new ArrayList<>();
            while (resultSet.next()){
                Goods goods = new Goods();
                goods.setGoodsid(resultSet.getInt("goodsid"));
                goods.setGoodsname(resultSet.getString("goodsname"));
                goods.setNewprice(resultSet.getDouble("newprice"));
                goods.setOldprice(resultSet.getDouble("oldprice"));
                goods.setNewkind(resultSet.getString("newkind"));
                goods.setStatus(resultSet.getInt("status"));
                goods.setGoodurl(resultSet.getString("goodurl"));
                goods.setBrand(resultSet.getString("brand"));
                goods.setRemark(resultSet.getString("remark"));
                goods.setKindid(resultSet.getInt("kindid"));
                goods.setAdminid(resultSet.getInt("adminid"));
                goods.setUserid(resultSet.getInt("userid"));
                goodsList.add(goods);
            }
            resultSet.close();
            preparedStatement.close();
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
    public void changegosadis(String sql, int goodsid, int adminid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,adminid);
            preparedStatement.setInt(2,goodsid);

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

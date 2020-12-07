package com.li.ers.dao.impl;

import com.li.ers.dao.IMineDAO;
import com.li.ers.db.DBershou;
import com.li.ers.model.Account;
import com.li.ers.model.Goods;
import com.li.ers.model.Kind;
import com.li.ers.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MineDAO implements IMineDAO {
    @Override
    public void updateMinefix(String sql, User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2,user.getUserpassword());
            preparedStatement.setString(3,user.getUsertel());
            preparedStatement.setString(4,user.getUserurl());
            preparedStatement.setString(5,user.getUseraddress());
            preparedStatement.setInt(6,user.getUserid());

            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            DBershou.release(connection);
        }
    }

    @Override
    public int addmoney(String sql, Account account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getAccount());
            preparedStatement.setDouble(2,account.getBalance());
            preparedStatement.setInt(3,account.getUserid());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return 0;
    }

    @Override
    public int addgoods(String sql, Goods goods) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            System.out.println(goods.getGoodsname());
            preparedStatement.setString(1,goods.getGoodsname());
            preparedStatement.setDouble(2,goods.getNewprice());
            preparedStatement.setDouble(3,goods.getOldprice());
            preparedStatement.setString(4,goods.getNewkind());
            preparedStatement.setInt(5,goods.getStatus());
            preparedStatement.setString(6,goods.getGoodurl());
            preparedStatement.setString(7,goods.getBrand());
            preparedStatement.setString(8,goods.getRemark());
            preparedStatement.setInt(9,goods.getKindid());
            preparedStatement.setInt(10,goods.getAdminid());
            preparedStatement.setInt(11,goods.getUserid());


            preparedStatement.executeUpdate();

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            DBershou.release(connection);
        }
        return 0;
    }

    @Override
    public List<Kind> getkind(String sql) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            connection = DBershou.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            List<Kind> kindlist = new ArrayList<>();
            while (resultSet.next()){
                Kind kind = new Kind();
                kind.setKindid(resultSet.getInt("kindid"));
                kind.setKindname(resultSet.getString("kindname"));

                kindlist.add(kind);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return kindlist;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

}

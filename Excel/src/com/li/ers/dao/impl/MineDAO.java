package com.li.ers.dao.impl;

import com.li.ers.dao.IMineDAO;
import com.li.ers.db.DBershou;
import com.li.ers.model.Account;
import com.li.ers.model.Goods;
import com.li.ers.model.Kind;
import com.li.ers.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MineDAO implements IMineDAO {
    @Override
    public int updateMinefix(String sql, User user) {
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

            return user.getUserid();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            DBershou.release(connection);
        }
        return 0;
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

    @Override
    public List<Goods> goods0(String sql, int userid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userid);
            resultSet = preparedStatement.executeQuery();
            List<Goods> goods0L = new ArrayList<>();
            while (resultSet.next()){
                Goods goods0 = new Goods();
                goods0.setGoodsid(resultSet.getInt("goodsid"));
                goods0.setGoodsname(resultSet.getString("goodsname"));
                goods0.setNewprice(resultSet.getDouble("newprice"));
                goods0.setOldprice(resultSet.getDouble("oldprice"));
                goods0.setNewkind(resultSet.getString("newkind"));
                goods0.setStatus(resultSet.getInt("status"));
                goods0.setGoodurl(resultSet.getString("goodurl"));
                goods0.setBrand(resultSet.getString("brand"));
                goods0.setRemark(resultSet.getString("remark"));
                goods0.setKindid(resultSet.getInt("kindid"));
                goods0.setAdminid(resultSet.getInt("adminid"));
                goods0.setUserid(resultSet.getInt("userid"));
                goods0L.add(goods0);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return goods0L;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public void changestaute(String sql, int goodsid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,2);
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

    @Override
    public void changemoney(String sql, int userid, double goodsmoney) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String Sql = "select * from account where userid = ?";
            double cardmondey =  findcard(Sql,userid);
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            double money = cardmondey + goodsmoney;
            preparedStatement.setDouble(1,money);
            preparedStatement.setInt(2,userid);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
    }

    /**
     * 删除商品
     * @param sql
     * @param goodsid
     */
    @Override
    public void deletegoods(String sql, int goodsid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goodsid);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
    }

    @Override
    public void changestaute0(String sql, int goodsid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,0);
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

    private double findcard(String sql, int userid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,userid);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                double money = resultSet.getDouble("balance");
                connection.close();
                preparedStatement.close();
                resultSet.close();

                return money;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            DBershou.release(connection);
        }

        return 0;
    }


}

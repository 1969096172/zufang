package com.li.ers.dao.impl;

import com.li.ers.dao.HomegoodsDAO;
import com.li.ers.db.DBershou;
import com.li.ers.model.Goods;
import com.li.ers.model.User;
import com.li.ers.web.CriteriaGoods;
import com.li.ers.web.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HomegoodsDAOImpl<T> extends BaseDAO<Goods> implements HomegoodsDAO {

    @Override
    public Page<Goods> getPage(CriteriaGoods cc) {
        // TODO Auto-generated method stub
        Page<Goods> page = new Page<>(cc.getPageNo());

        page.setTotalItemNumber(getTotalComputerNumber(cc));
        //校验pageNo的合法性
        cc.setPageNo(page.getPageNo());
        page.setList(getPageList(cc, 6));
        return page;
    }
    @Override
    public long getTotalComputerNumber(CriteriaGoods cc) {
        // TODO Auto-generated method stub
        String sql = "SELECT count(goodsid) FROM goods WHERE newprice BETWEEN ? AND ?";
        return getSingleVal(sql, cc.getMinPrice(), cc.getMaxPrice());
    }

    @Override
    public List<Goods> getPageList(CriteriaGoods cc, int pageSize) {
        // TODO Auto-generated method stub
        String sql = "SELECT goodsid,goodsname,newprice,oldprice,newkind,"+
                "status,goodurl,brand,remark,kindid,adminid,userid FROM goods WHERE newprice BETWEEN ? AND ?"+
                "LIMIT ?,?";

        return queryForList(sql, cc.getMinPrice(),cc.getMaxPrice(),(cc.getPageNo() - 1)*pageSize,pageSize);
    }

    @Override
    public User getmine(String sql,int userid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,userid);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setUserid(userid);
                user.setUsername(resultSet.getString("username"));
                user.setUserpassword(resultSet.getString("userpassword"));
                user.setUsertel(resultSet.getString("usertel"));
                user.setUserurl(resultSet.getString("userurl"));
                user.setUseraddress(resultSet.getString("useraddress"));
                user.setAdminid(resultSet.getInt("adminid"));

                connection.close();
                preparedStatement.close();
                resultSet.close();

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            DBershou.release(connection);
        }

        return null;
    }

    @Override
    public List<Goods> getserch(String sql, String serch) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,serch);
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
    public Goods getgoods(String sql, int goodsid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goodsid);
            resultSet = preparedStatement.executeQuery();
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
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return goods;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public int chagcrad(String sql, String dtmon, double dtpic, int userdtid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1,dtpic);
            preparedStatement.setInt(2,userdtid);
            preparedStatement.setString(3,dtmon);
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
    public void changestaute1(String sql, int goodsid) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
    }

}

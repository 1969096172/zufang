package com.li.ers.dao.impl;

import com.li.ers.dao.HomegoodsDAO;
import com.li.ers.db.DBershou;
import com.li.ers.model.Goods;
import com.li.ers.model.User;
import com.li.ers.web.CriteriaComputer;
import com.li.ers.web.Page;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class HomegoodsDAOImpl<T> extends BaseDAO<Goods> implements HomegoodsDAO {

    @Override
    public Page<Goods> getPage(CriteriaComputer cc) {
        // TODO Auto-generated method stub
        Page<Goods> page = new Page<>(cc.getPageNo());

        page.setTotalItemNumber(getTotalComputerNumber(cc));
        //校验pageNo的合法性
        cc.setPageNo(page.getPageNo());
        page.setList(getPageList(cc, 6));
        return page;
    }
    @Override
    public long getTotalComputerNumber(CriteriaComputer cc) {
        // TODO Auto-generated method stub
        String sql = "SELECT count(goodsid) FROM goods WHERE newprice BETWEEN ? AND ?";
        return getSingleVal(sql, cc.getMinPrice(), cc.getMaxPrice());
    }

    @Override
    public List<Goods> getPageList(CriteriaComputer cc, int pageSize) {
        // TODO Auto-generated method stub
        String sql = "SELECT goodsid,goodsname,newprice,oldprice,newkind,"+
                "status,goodurl,brand,remark,kindid FROM goods WHERE newprice BETWEEN ? AND ?"+
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

}

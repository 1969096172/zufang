package com.li.ers.dao.impl;

import com.li.ers.dao.ILoginDAO;
import com.li.ers.db.DBershou;
import com.li.ers.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO implements ILoginDAO {
    @Override
    public int user_login_in(String sql, String useraccount, String userpassword) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,useraccount);
            preparedStatement.setString(2,userpassword);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){

                int userid =  resultSet.getInt("userid");

                resultSet.close();
                preparedStatement.close();
                connection.close();
                return userid;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            DBershou.release(connection);
        }

        return 0;
    }

    @Override
    public int admin_login_in(String sql, String useraccount, String userpassword) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,useraccount);
            preparedStatement.setString(2,userpassword);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){

                int adminid =  resultSet.getInt("adminid");

                resultSet.close();
                preparedStatement.close();
                connection.close();
                return adminid;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            DBershou.release(connection);
        }

        return 0;
    }
}

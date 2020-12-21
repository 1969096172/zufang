package com.li.ers.dao.impl;

import com.li.ers.dao.ILoginDAO;
import com.li.ers.db.DBershou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO implements ILoginDAO {


    @Override
    public int user_login_in(String useraccount, String userpassword) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "select * from user where useraccount = ? and userpassword = ?";
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
}

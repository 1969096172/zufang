package com.li.ers.dao.impl;

import com.li.ers.dao.IAdduserDAO;
import com.li.ers.db.DBershou;
import com.li.ers.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdduserDAO implements IAdduserDAO {
    @Override
    public void adduser(User user, String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getUserpassword());
            preparedStatement.setString(3,user.getUsertel());

            preparedStatement.setString(4,user.getUserurl());
            preparedStatement.setString(5,user.getUseraddress());
            preparedStatement.setInt(6,user.getAdminid());

            preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            DBershou.release(connection);
        }
    }
}

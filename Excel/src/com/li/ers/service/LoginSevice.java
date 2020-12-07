package com.li.ers.service;

import com.li.ers.dao.ILoginDAO;
import com.li.ers.dao.impl.LoginDAOImpl;
import com.li.ers.model.User;

public class LoginSevice {
    ILoginDAO logindao = new LoginDAOImpl();
    public int login_in(String useraccount, String userpassword){
        String sql = "select * from user where username = ? and userpassword = ?";

        int userid = logindao.user_login_in(sql, useraccount,userpassword);
        return userid;
    }
}

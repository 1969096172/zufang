package com.li.ers.service;

import com.li.ers.dao.ILoginDAO;
import com.li.ers.dao.impl.LoginDAO;

public class LoginService {
    ILoginDAO loginDAO = new LoginDAO();
    public int login_in(String useraccount, String userpassword) {
        int userid = loginDAO.user_login_in( useraccount,userpassword);
        return userid;
    }
}

package com.li.ers.service;

import com.li.ers.dao.IAdduserDAO;
import com.li.ers.dao.impl.AdduserDAO;
import com.li.ers.model.User;

public class AdduserService {

    private IAdduserDAO adduser = new AdduserDAO();
    public void adduser(User user) {
        String sql = "insert into user(username, userpassword, usertel, userurl, useraddress, adminid) values(?,?,?,?,?,?)";
        System.out.println(user.getUserurl());
        adduser.adduser(user,sql);
    }
}

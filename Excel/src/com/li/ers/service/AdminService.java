package com.li.ers.service;

import com.li.ers.dao.IAdduserDAO;
import com.li.ers.dao.IAdminDAO;
import com.li.ers.dao.IMineDAO;
import com.li.ers.dao.impl.AdminDAO;
import com.li.ers.dao.impl.MineDAO;
import com.li.ers.model.Goods;
import com.li.ers.model.User;

import java.util.List;

public class AdminService {
    IAdminDAO adminDAO = new AdminDAO();
    IMineDAO mineDAO = new MineDAO();
    public List<Goods> getad0goods() {
        String sql = "select * from goods where adminid = 1";
        List<Goods> goodsList = adminDAO.getad0goods(sql);
        return goodsList;
    }

    public void changegosadis(int goodsid, int adminid) {
        String sql = "update goods set adminid=? where goodsid=?";
        adminDAO.changegosadis(sql, goodsid, adminid);
    }

    public void refusegos(int goodsid) {
        String sql = "delete from goods where goodsid=?";
        mineDAO.deletegoods(sql,goodsid);
    }

    public List<User> getUser() {
        String sql = "select * from user";
        List<User> userList = adminDAO.getuser(sql);
        return userList;
    }
}

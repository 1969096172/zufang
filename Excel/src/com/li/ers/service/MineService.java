package com.li.ers.service;

import com.li.ers.dao.IMineDAO;
import com.li.ers.dao.impl.MineDAO;
import com.li.ers.model.Account;
import com.li.ers.model.Goods;
import com.li.ers.model.Kind;
import com.li.ers.model.User;

import java.util.List;

public class MineService {
    IMineDAO mineDAO = new MineDAO();
    public void fixuser(User user) {
        String sql = "update user set username=?, userpassword=?, usertel=?, userurl=?, useraddress=? where userid=?";
        mineDAO.updateMinefix(sql,user);
    }

    public int getmoney(Account account) {
        String sql = "insert into account(account, balance, userid) values(?,?,?)";
        int userre = mineDAO.addmoney(sql,account);
        return userre;
    }


    public int addgoods(Goods goods) {
        String sql = "insert into goods(goodsname, newprice, oldprice, newkind, status, goodurl, brand, remark, kindid, adminid, userid) values(?,?,?,?,?,?,?,?,?,?,?)";
        int goodsre = mineDAO.addgoods(sql,goods);
        return goodsre;
    }

    public List<Kind> getkind() {
        String sql = "select * from kind";
        List<Kind> kind = mineDAO.getkind(sql);
        return kind;
    }
}

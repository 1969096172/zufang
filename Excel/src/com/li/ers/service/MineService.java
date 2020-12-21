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
    public int fixuser(User user) {
        String sql = "update user set username=?, userpassword=?, usertel=?, userurl=?, useraddress=? where userid=?";
        int userid =  mineDAO.updateMinefix(sql,user);
        return userid;
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

    public List<Goods> getgoods0(int userid) {
        String sql = "select * from goods where status = 0 and adminid != 1 and userid = ?";
        List<Goods> goods0 = mineDAO.goods0(sql, userid);
        return goods0;
    }

    public List<Goods> getgoods1(int userid) {
        String sql = "select * from goods where status = 1 and adminid != 1 and userid = ?";
        List<Goods> goods0 = mineDAO.goods0(sql, userid);
        return goods0;
    }

    public List<Goods> getgoods2(int userid) {
        String sql = "select * from goods where status = 2 and adminid != 1 and userid = ?";
        List<Goods> goods0 = mineDAO.goods0(sql, userid);
        return goods0;
    }

    public void changestate(int goodsid) {
        String sql = "update goods set status=? where goodsid=?";
        mineDAO.changestaute(sql,goodsid);
    }

    public void changemoney(int userid, double goodsmoney) {
        String sql = "update account set balance=? where userid=?";
        mineDAO.changemoney(sql,userid,goodsmoney);
    }

    public void deletegoods(int goodsid) {
        String sql = "delete from goods where goodsid=?";
        mineDAO.deletegoods(sql,goodsid);
    }

    public void changestate0(int goodsid) {
        String sql = "update goods set status=? where goodsid=?";
        mineDAO.changestaute0(sql,goodsid);
    }

    public void ccstor(int goodsid) {
        String sql = "update orders set orderstate=1 where goodsid=?";
        mineDAO.chang(sql,goodsid);
    }
}

package com.li.ers.service;

import com.li.ers.dao.IHomegoodsDAO;
import com.li.ers.dao.impl.HomegoodsDAO;
import com.li.ers.model.Goods;
import com.li.ers.model.User;
import com.li.ers.web.CriteriaGoods;
import com.li.ers.web.Page;

import java.util.List;

public class HomeService {

    private IHomegoodsDAO homegoodsDAO = new HomegoodsDAO();

    public Page<Goods> getPage(CriteriaGoods cc){
        return homegoodsDAO.getPage(cc);
    }
    public User getmine(int userid){
        String sql = "select * from user where userid = ?";
        return homegoodsDAO.getmine(sql,userid);
    }

    public List<Goods> getserch(String serch) {
        String sql = "select * from goods where goodsname = ?";
        List<Goods> goodsList = homegoodsDAO.getserch(sql, serch);
        return goodsList;
    }

    public Goods getgoods(int goodsid) {
        String sql = "select * from goods where goodsid = ?";
        Goods goods = homegoodsDAO.getgoods(sql,goodsid);
        return goods;
    }

    public int chagcard(double dtpic, String dtmon, int userdtid) {
        String sql = "update account set balance=balance-? where userid=? and account=?";
        int i = homegoodsDAO.chagcrad(sql,dtmon,dtpic,userdtid);
        return i;
    }

    public void changestate1(int goodsid) {
        String sql = "update goods set status=1 where goodsid=?";
        homegoodsDAO.changestaute1(sql,goodsid);
    }
}

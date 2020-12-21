package com.li.ers.dao;

import com.li.ers.model.Goods;
import com.li.ers.model.User;
import com.li.ers.web.CriteriaGoods;
import com.li.ers.web.Page;

import java.util.List;

public interface IHomegoodsDAO {
    /**
     *
     * @return
     */
    Page<Goods> getPage(CriteriaGoods cc);

    long getTotalGoodsNumber(CriteriaGoods cc);

    List<Goods> getPageList(CriteriaGoods cc, int pageSize);

    User getmine(String sql,int userid);

    List<Goods> getserch(String sql, String serch);

    Goods getgoods(String sql, int goodsid);

    int chagcrad(String sql, String dtmon, double dtpic, int userdtid);

    void changestaute1(String sql, int goodsid);
}

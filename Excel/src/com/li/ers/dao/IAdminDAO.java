package com.li.ers.dao;

import com.li.ers.model.Goods;

import java.util.List;

public interface IAdminDAO {
    List<Goods> getad0goods(String sql);

    void changegosadis(String sql, int goodsid, int adminid);
}

package com.li.ers.dao;

import com.li.ers.model.Account;
import com.li.ers.model.Goods;
import com.li.ers.model.Kind;
import com.li.ers.model.User;

import java.util.List;

public interface IMineDAO {

    int updateMinefix(String sql, User user);

    int addmoney(String sql, Account account);

    int addgoods(String sql, Goods goods);

    List<Kind> getkind(String sql);

    List<Goods> goods0(String sql, int userid);

    void changestaute(String sql, int goodsid);

    void changemoney(String sql, int goodsid, double goodsmoney);

    void deletegoods(String sql, int goodsid);

    void changestaute0(String sql, int goodsid);

    void chang(String sql, int goodsid);
}

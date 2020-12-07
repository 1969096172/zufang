package com.li.ers.dao;

import com.li.ers.model.Account;
import com.li.ers.model.Goods;
import com.li.ers.model.Kind;
import com.li.ers.model.User;

import java.util.List;

public interface IMineDAO {

    void updateMinefix(String sql, User user);

    int addmoney(String sql, Account account);

    int addgoods(String sql, Goods goods);

    List<Kind> getkind(String sql);
}

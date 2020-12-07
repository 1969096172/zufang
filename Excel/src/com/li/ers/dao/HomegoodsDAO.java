package com.li.ers.dao;

import com.li.ers.model.Goods;
import com.li.ers.model.User;
import com.li.ers.web.CriteriaComputer;
import com.li.ers.web.Page;

import java.util.List;

public interface HomegoodsDAO {
    /**
     *
     * @return
     */
    Page<Goods> getPage(CriteriaComputer cc);

    long getTotalComputerNumber(CriteriaComputer cc);

    List<Goods> getPageList(CriteriaComputer cc, int pageSize);

    User getmine(String sql,int userid);

}

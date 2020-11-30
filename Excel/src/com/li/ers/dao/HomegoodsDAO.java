package com.li.ers.dao;

import com.li.ers.model.Goods;
import com.li.ers.web.CriteriaComputer;
import com.li.ers.web.Page;

import java.util.List;

public interface HomegoodsDAO {
    /**
     *
     * @return
     */
    public abstract Page<Goods> getPage(CriteriaComputer cc);

    public abstract long getTotalComputerNumber(CriteriaComputer cc);

    public abstract List<Goods> getPageList(CriteriaComputer cc, int pageSize);

}

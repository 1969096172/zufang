package com.li.ers.service;

import com.li.ers.dao.HomegoodsDAO;
import com.li.ers.dao.impl.HomegoodsDAOImpl;
import com.li.ers.model.Goods;
import com.li.ers.service.impl.IHomeService;
import com.li.ers.web.CriteriaComputer;
import com.li.ers.web.Page;

import java.util.List;

public class HomeService {

    private HomegoodsDAO homegoodsDAO = new HomegoodsDAOImpl();

    public Page<Goods> getPage(CriteriaComputer cc){
        return homegoodsDAO.getPage(cc);
    }
}

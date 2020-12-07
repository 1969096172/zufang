package com.li.ers.dao;

import com.li.ers.model.User;

public interface ILoginDAO {
    int user_login_in(String sql, String useraccount, String userpassword);
}

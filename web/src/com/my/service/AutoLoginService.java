package com.my.service;

import com.my.dao.AutoLoginDao;
import com.my.domain.User;

import java.sql.SQLException;

public class AutoLoginService {
    public User login(String username, String password) throws SQLException {
        AutoLoginDao autoLoginDao=new AutoLoginDao();
        return  autoLoginDao.login(username,password);
    }
}

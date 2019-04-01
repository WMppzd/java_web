package com.my.service;

import com.my.dao.UsernameIsExistDao;

import java.sql.SQLException;

public class UsernameIsExistService {
    public Boolean isExistUsername(String username) throws SQLException {
        UsernameIsExistDao usernameIsExistDao = new UsernameIsExistDao();
        Boolean isExist=usernameIsExistDao.isExistUsername(username);
        return isExist;
    }
}

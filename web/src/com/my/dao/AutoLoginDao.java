package com.my.dao;

import com.my.domain.User;
import com.my.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AutoLoginDao {
    public User login(String username, String password) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from user1 where username=? and password=?";
//        System.out.print(sql);
        return queryRunner.query(sql,new BeanHandler<User>(User.class),username,password);
    }
}

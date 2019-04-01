package com.my.dao;

import com.my.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UsernameIsExistDao {
    public Boolean isExistUsername(String username) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select count(*) from user where username=?";
        Long number=(Long) queryRunner.query(sql,new ScalarHandler(),username);
        return number.intValue()>0?false:true;
    }
}

package com.my.dao;

import com.my.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductByKeyWordDao {
    public List<Object> findListByKey(String keyWord) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product where pname like  ?  limit 0 , 8";
        List<Object> pro=queryRunner.query(sql,new ColumnListHandler("pname"),"%"+keyWord+"%");
        return pro;
    }
}

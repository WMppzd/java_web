package com.my.dao;

import com.my.domain.Product;
import com.my.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductByPageDao {
    public int getTotal() throws SQLException {
       QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
       String  sql="select count(*) from product";
       Long total=(Long) queryRunner.query(sql,new ScalarHandler());
       return  total.intValue();
    }

    public List<Product> getList(int currentPage, int pageSize) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product limit ? ,?";
        List<Product> products=queryRunner.query(sql,new BeanListHandler<Product>(Product.class),(currentPage-1)*pageSize,pageSize);
        return  products;
    }
}

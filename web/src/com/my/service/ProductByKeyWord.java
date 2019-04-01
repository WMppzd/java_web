package com.my.service;

import com.my.dao.ProductByKeyWordDao;
import com.my.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductByKeyWord {

    public List findListByKey(String keyWord) throws SQLException {
        ProductByKeyWordDao productByKeyWordDao=new ProductByKeyWordDao();
        List<Object> productList=productByKeyWordDao.findListByKey(keyWord);
        return  productList;
    }
}

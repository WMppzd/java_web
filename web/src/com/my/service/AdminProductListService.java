package com.my.service;

import com.my.dao.AdminProductListDao;
import com.my.domain.Category;
import com.my.domain.Product;
import com.my.vo.Condition;

import java.sql.SQLException;
import java.util.List;

public class AdminProductListService {
    public List<Product> getAllList() throws SQLException {
        AdminProductListDao product=new AdminProductListDao();
        List<Product> list = product.getAllList();
        return list;
    }

    public List<Category> getCateGory() throws SQLException {
        AdminProductListDao cateGory=new AdminProductListDao();
        List<Category> cate = cateGory.getCateGory();
        return  cate;

    }

    public void addProduct(Product product) throws SQLException {
        AdminProductListDao adminProductListDao=new AdminProductListDao();
        adminProductListDao.addProduct(product);
    }

    public void delList(String pid) throws SQLException {
        AdminProductListDao adminProductListDao=new AdminProductListDao();
        adminProductListDao.delList(pid);
    }


    public void editProduct(Product product) throws SQLException {
        AdminProductListDao adminProductListDao=new AdminProductListDao();
        adminProductListDao.editProduct(product);
    }

    public Product getDetails(String pid) throws SQLException {
        AdminProductListDao adminProductListDao=new AdminProductListDao();
        Product product=adminProductListDao.getDetails(pid);
        return  product;
    }

    public List<Product> getListByCondition(Condition condition) throws SQLException {
        AdminProductListDao adminProductListDao=new AdminProductListDao();
        return adminProductListDao.getListByCondition(condition);
    }
}

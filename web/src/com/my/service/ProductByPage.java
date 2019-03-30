package com.my.service;

import com.my.dao.ProductByPageDao;
import com.my.domain.Product;
import com.my.vo.PageBean;

import java.sql.SQLException;
import java.util.List;

public class ProductByPage {
    public static PageBean getPageBean(int currentPage,int pageSize) throws SQLException {
        PageBean<Product> pageBean=new PageBean<Product>();
//        当前页
        pageBean.setCurrentPage(currentPage);
//        每页条数
        pageBean.setPageSize(pageSize);

//        总数
        ProductByPageDao product= new ProductByPageDao();
        int total=product.getTotal();
        pageBean.setTotalCount(total);
//        总页数
        int pageTotal= (int) Math.ceil(1.0*total/pageSize);
        pageBean.setTotalPage(pageTotal);
        List<Product> list = product.getList(currentPage,pageSize);
        pageBean.setProducts(list);
        return  pageBean;
    }
}

package com.my.dao;

import com.my.domain.Category;
import com.my.domain.Product;
import com.my.utils.DataSourceUtils;
import com.my.vo.Condition;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminProductListDao {
    public List<Product> getAllList() throws SQLException {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product";
        List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
        System.out.print(list);
        return list;
    }

    public List<Category> getCateGory() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from category";
        Category category=new Category();
        List<Category> list = queryRunner.query(sql,new BeanListHandler<Category>(Category.class));
        return  list;

    }

    public void addProduct(Product product) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert into product values(?,?,?,?,?,?,?,?,?,?)";
        queryRunner.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),
                product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),
                product.getPdesc(),product.getPflag(),product.getCid());
    }

    public void delList(String pid) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="delete from product where pid=?";
        queryRunner.update(sql,pid);

    }

    public void editProduct(Product product) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
        queryRunner.update(sql,product.getPname(),product.getMarket_price(),
                product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),
                product.getPdesc(),product.getPflag(),product.getCid(),product.getPid());
    }

    public Product getDetails(String pid) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product where pid=?";
        Product product=queryRunner.query(sql,new BeanHandler<Product>(Product.class),pid);
        return  product;
    }

    public List<Product> getListByCondition(Condition condition) throws SQLException {
        List<String> con=new ArrayList<String>();
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product where 1=1 ";
        if(condition.getPname()!=null&&!condition.getPname().trim().equals("")){
            sql+="and pname like ?";
            con.add("%"+condition.getPname().trim()+"%");
        }
        if(condition.getIsHot()!=null&&!condition.getIsHot().equals("")){
            sql+="and is_hot = ?";
            con.add(condition.getIsHot());
        }
        if(condition.getCategory()!=null&&!condition.getCategory().equals("")){
            sql+="and cid= ?";
            con.add(condition.getCategory());
        }
        System.out.print(sql);
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class),con.toArray());
    }
}

package com.my.web;

import com.my.domain.Category;
import com.my.domain.Product;
import com.my.service.AdminProductListService;
import com.my.vo.Condition;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@WebServlet(name = "ProductListByConditionServlet")
public class ProductListByConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String,String[]> properties=request.getParameterMap();
        Condition condition=new Condition();
        try {
            BeanUtils.populate(condition, properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        AdminProductListService adminProductListService=new AdminProductListService();
        List<Product> products= null;
        try {
            products = adminProductListService.getListByCondition(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Category> categoryList = null;
        try {
            categoryList = adminProductListService.getCateGory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("condition", condition);
        request.setAttribute("category", categoryList);
        request.setAttribute("list",products);
        System.out.print(products);
        request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);
    }
}

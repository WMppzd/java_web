package com.my.web;

import com.my.domain.Product;
import com.my.service.AdminProductListService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "AddProductList")
public class AddProductList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String,String[]> prodies=request.getParameterMap();
        Product product = new Product();
        try {
            BeanUtils.populate(product,prodies);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        product.setPid(UUID.randomUUID().toString());
        product.setPimage("products/1/c_0033.jpg");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date=dateFormat.format(new Date());
        product.setPdate(date);
        product.setPflag(0);
        AdminProductListService adminProductListService=new AdminProductListService();
        try {
            adminProductListService.addProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/list");
    }
}

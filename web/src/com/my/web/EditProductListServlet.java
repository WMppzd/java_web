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
import java.util.Map;

@WebServlet(name = "EditProductListServlet")
public class EditProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String pid=request.getParameter("pid");
        request.setCharacterEncoding("UTF-8");
        Map<String,String[]> properties=request.getParameterMap();
        Product product=new Product();
        try {
            BeanUtils.populate(product,properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        AdminProductListService adminProductListService=new AdminProductListService();
        try {
            adminProductListService.editProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/list");
    }
}

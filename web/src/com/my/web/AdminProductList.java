package com.my.web;

import com.my.domain.Product;
import com.my.service.AdminProductListService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminProductList extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.print("来请求过了");
        AdminProductListService product=new AdminProductListService();
        List<Product> list =null;
        try {
            list=product.getAllList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        System.out.println(list);
        request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);
    }
}

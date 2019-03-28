package com.my.web;

import com.my.domain.Category;
import com.my.service.AdminProductListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddListUI")
public class AddListUI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminProductListService cateGory= new AdminProductListService();
        List<Category> list = null;
        try {
            list=cateGory.getCateGory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("category",list);
        request.getRequestDispatcher("/admin/product/add.jsp").forward(request,response);
    }
}

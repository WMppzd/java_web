package com.my.web;

import com.my.domain.Category;
import com.my.domain.Product;
import com.my.service.AdminProductListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EditListUIServlet")
public class EditListUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid=request.getParameter("pid");
        AdminProductListService adminProductListService=new AdminProductListService();
        Product product=null;
        try {
            product=adminProductListService.getDetails(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Category> list = null;
        try {
            list=adminProductListService.getCateGory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print(product);
        System.out.print(list);
        request.setAttribute("details",product);
        request.setAttribute("category",list);
        request.getRequestDispatcher("/admin/product/edit.jsp").forward(request,response);
    }
}

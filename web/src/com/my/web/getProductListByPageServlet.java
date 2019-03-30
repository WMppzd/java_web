package com.my.web;

import com.my.service.ProductByPage;
import com.my.vo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

@WebServlet(name = "getProductListByPageServlet")
public class getProductListByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductByPage product = new ProductByPage();
        PageBean list=null;
        String currentPageStr=request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
        int currentPage= Integer.parseInt(currentPageStr);
//        每页条数
        int pageSize=12;
        try {
             list=ProductByPage.getPageBean( currentPage, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("pageBean",list);
        System.out.print(list);
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }
}

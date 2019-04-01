package com.my.web;

import com.google.gson.Gson;
import com.my.domain.Product;
import com.my.service.ProductByKeyWord;
import net.sf.json.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchKeyWordServlet")
public class SearchKeyWordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyWord=request.getParameter("keyWord");
        ProductByKeyWord productByKeyWord=new ProductByKeyWord();
        List productList=null;
        try {
            productList=productByKeyWord.findListByKey(keyWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print(productList);
        Gson gson=new Gson();
        String json=gson.toJson(productList);
//        System.out.print(json);
        response.setContentType("html/text;charset=utf-8");
        response.getWriter().write(json);
    }
}

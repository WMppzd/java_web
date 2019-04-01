package com.my.web;

import com.my.service.UsernameIsExistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UsernameIsExistServlet")
public class UsernameIsExistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        Boolean isExist=false;
        UsernameIsExistService usernameIsExistService= new UsernameIsExistService();
        try {
            isExist=usernameIsExistService.isExistUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print(isExist);
//            response.setContentType("html/text;charset=utf-8");
            response.getWriter().write("{\"isExist\":"+isExist+"}");

    }
}

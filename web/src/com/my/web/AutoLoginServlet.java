package com.my.web;

import com.my.domain.User;
import com.my.service.AutoLoginService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

//@WebServlet(name = "AutoLoginServlet")
public class AutoLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String isAutoLogin=request.getParameter("autoLogin");
        AutoLoginService autoLoginService=new AutoLoginService();
        System.out.println("login:::::::"+isAutoLogin);
        User user=null;
        HttpSession session = request.getSession();
        try {
            user=autoLoginService.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print(user);
        if(user!=null){
            if(isAutoLogin!=null){
                String username_code = URLEncoder.encode(username, "UTF-8");// %AE4%kfj
                Cookie ucookie=new Cookie("username",username_code);
                Cookie pcookie=new Cookie("password",password);
                ucookie.setMaxAge(60*60);
                pcookie.setMaxAge(60*60);
                response.addCookie(ucookie);
                response.addCookie(pcookie);
//                System.out.print(ucookie+"---------"+pcookie);
            }
            session.setAttribute("user",user);
            response.sendRedirect(request.getContextPath());
        }else {
            request.setAttribute("isLogin","请重新输入");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}

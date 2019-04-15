package com.my.web.fileter;


import com.my.domain.User;
import com.my.service.AutoLoginService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

//@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        System.out.print("filter   runnitn.......");
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse)resp;
        HttpSession session=request.getSession();
        String ucookie = null;
        String pcookie= null;
        Cookie[] cookies=request.getCookies();
//        System.out.println("cookies:"+cookies);
        if (cookies!=null){
            for (Cookie cookie:cookies
                 ) {
//                System.out.println("cookieName:"+cookie.getName());
                if("username".equals(cookie.getName())){
                    ucookie=cookie.getValue();
                    ucookie = URLDecoder.decode(ucookie, "UTF-8");
                }
                if("password".equals(cookie.getName())){
                    pcookie=cookie.getValue();
                }
            }
            System.out.println(ucookie);
            System.out.println(pcookie);
        }
        if(ucookie!=null&&pcookie!=null){
            AutoLoginService autoLoginService=new AutoLoginService();
            User user=null;
            try {
                user=autoLoginService.login(ucookie,pcookie);
            } catch (SQLException e) {
                e.printStackTrace();

            }
            System.out.print("1111111111111"+user);
            session.setAttribute("user", user);
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.filter;

import cth.webapp.duogames.duogames.control.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicla
 */

@WebFilter({"/userprofile.xhtml", "/play.xhtml", "/quiz.xhtml"})
public class LogiFilter implements Filter {
    @Inject
    UserBean user;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpreq = (HttpServletRequest) request;
        HttpServletResponse httpres = (HttpServletResponse) response; 
        HttpSession ses = httpreq.getSession(false);
        //UserBean user = (UserBean) httpreq.getSession().getAttribute("user");
        //UserBean user2 = (UserBean) request.getAttribute("user");
        //System.out.println(user + "  HEJAQ  " + user2);
        //boolean isLoggedIn = false;
        //isLoggedIn = (boolean) ses.getAttribute("isLoggedIn");
        if(user.getIsLoggedIn())
        chain.doFilter(request, response);
        
        else{
            httpres.sendRedirect(httpreq.getContextPath() + "/index.xhtml");
        }
        
        //httpreq.get
        //httpres.sendRedirect(httpreq.getContextPath() + "/index.xhtml");
        
        
        
    }
    

    @Override
    public void destroy() {
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.filter;

import cth.webapp.duogames.duogames.control.ScoreBean;
import java.io.IOException;
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
@WebFilter("/score.xhtml")
public class ScoreFilter implements Filter {

    @Inject
    ScoreBean score;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpreq = (HttpServletRequest) request;
        HttpServletResponse httpres = (HttpServletResponse) response;
        HttpSession ses = httpreq.getSession(false);
        if (score.getGamebean() != null) {
            chain.doFilter(request, response);
        } else {
            httpres.sendRedirect(httpreq.getContextPath() + "/index.xhtml");
        }

        //httpreq.get
        //httpres.sendRedirect(httpreq.getContextPath() + "/index.xhtml");
    }

    @Override
    public void destroy() {

    }
}

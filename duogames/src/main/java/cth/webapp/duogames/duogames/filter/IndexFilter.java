package cth.webapp.duogames.duogames.filter;

import cth.webapp.duogames.duogames.control.UserBean;
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

@WebFilter("/index.xhtml")
public class IndexFilter implements Filter {

    @Inject
    UserBean user;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (user != null) {
            if (!user.getIsLoggedIn()) {
                chain.doFilter(request, response);
            } else {
                HttpServletRequest httpreq = (HttpServletRequest) request;
                HttpServletResponse httpres = (HttpServletResponse) response;
                httpres.sendRedirect(httpreq.getContextPath() + "/play.xhtml");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}

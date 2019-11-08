package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getRequestURI().contains("/singin")) {
            filterChain.doFilter(req, resp);
        } else {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("login") == null) {
                ((HttpServletResponse) resp).sendRedirect(String.format("%s/singin", request.getContextPath()));
                return;
            }
        filterChain.doFilter(req, resp);
        }
    }
}

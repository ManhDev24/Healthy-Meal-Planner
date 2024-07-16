package Filter;

import dto.Account;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorFilter implements Filter {

    private FilterConfig filterConfig = null;

    public AuthorFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("LoggedInUser") == null) {
            res.sendRedirect("MainController?action=login");
        } else {
            Account acc = (Account) session.getAttribute("LoggedInUser");
            if (!acc.isRole()) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect("403page.jsp");
            }
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }
}

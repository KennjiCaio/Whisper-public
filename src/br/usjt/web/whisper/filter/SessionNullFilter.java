package br.usjt.web.whisper.filter;

import java.io.IOException;
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

import br.usjt.web.whisper.model.Usuario;

/**
 * Servlet Filter implementation class SessionNullFilter
 */
@WebFilter(filterName = "/SessionNullFilter", urlPatterns = {"/cadastro.jsp", "/login.jsp", "/index.jsp"})
public class SessionNullFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionNullFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		
		if(usuario != null) {
			((HttpServletResponse)response).sendRedirect("Logout.do");
		}
		else {
			chain.doFilter(request, response);
			
			((HttpServletResponse)response).setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			((HttpServletResponse)response).setHeader("Progma", "no-cache");
			((HttpServletResponse)response).setDateHeader("Expires", 0);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

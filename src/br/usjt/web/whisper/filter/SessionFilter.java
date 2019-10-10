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

@WebFilter(filterName = "/SessionFilter", urlPatterns = {"/homepage.jsp","/navbar.jsp", "/perfil.jsp"})
public class SessionFilter implements Filter {

    public SessionFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		
		if(usuario == null) {
			((HttpServletResponse)response).sendRedirect("Logout.do");
		}
		else {
			chain.doFilter(request, response);
			
			((HttpServletResponse)response).setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			((HttpServletResponse)response).setHeader("Progma", "no-cache");
			((HttpServletResponse)response).setDateHeader("Expires", 0);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

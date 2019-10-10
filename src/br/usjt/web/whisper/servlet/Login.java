package br.usjt.web.whisper.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.web.whisper.model.Usuario;
import br.usjt.web.whisper.service.UsuarioService;
import br.usjt.web.whisper.util.Util;

@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("txtEmail");
			String senha = request.getParameter("txtSenha");
			
			UsuarioService usuarioService = new UsuarioService();
			Util util = new Util();
			
			Usuario usuarioCons = usuarioService.consultaLogin(email);
			boolean senhaCons = util.matching(usuarioCons.getSenha(), senha);
			
			if(senhaCons == true) {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuarioLogado", usuarioCons);
				response.sendRedirect("homepage.jsp");
			}
			else {
				response.sendRedirect("index.jsp?erro=email.senha.incorreto");
			}
		} catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("index.jsp?erro=email.nao.cadastrado");
		}
	}
}

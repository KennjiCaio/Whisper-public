package br.usjt.web.whisper.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.whisper.service.UsuarioService;

@WebServlet("/Valida.do")
public class Valida extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		UsuarioService userService = new UsuarioService();
		
		if(action.equals("validaNick")) {
			String nick = request.getParameter("nick");
			boolean nickValido = userService.validaNick(nick);
			if(nickValido == true) {
				out.print("nicktrue");
			} 
			else {
				out.print("nickfalse");
			}
		}
		else if(action.equals("validaEmail")) {
			String email = request.getParameter("email");
			boolean emailValido = userService.validaEmail(email);
			if(emailValido == true) {
				out.print("emailtrue");
			} 
			else {
				out.print("emailfalse");
			}
		}
	}

}

package br.usjt.web.whisper.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.whisper.model.Usuario;
import br.usjt.web.whisper.service.UsuarioService;
import br.usjt.web.whisper.util.Util;

@WebServlet("/Cadastro.do")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("txtNome");
			String nick = request.getParameter("txtNick");
			String email = request.getParameter("txtEmail");
			String senha = request.getParameter("txtSenha");
			String dtNascString = request.getParameter("dtNascimento");
				
			UsuarioService usuaService = new UsuarioService();
			Util util = new Util();
			
			String senhaCripto = util.convertToMD5(senha);
			Date dtNasc = util.converteData(dtNascString);
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setNickname(nick);
			usuario.setEmail(email);
			usuario.setSenha(senhaCripto);
			usuario.setDtNascimento(dtNasc);
			usuaService.cadastrar(usuario);
			
			response.sendRedirect("index.jsp?status=cadSucess");
			
		} catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("index.jsp?status=cadFail");
		}
	}
}

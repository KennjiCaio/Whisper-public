package br.usjt.web.whisper.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.whisper.model.Seguidores;
import br.usjt.web.whisper.model.Usuario;
import br.usjt.web.whisper.service.SeguidoresService;

@WebServlet("/Seguir.do")
public class Seguir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		
		if(action.equals("seguir")) {
			Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogado");
			int idSeguido = Integer.parseInt(request.getParameter("idSeguido"));
			Seguidores usuarioSegue = new Seguidores();
			SeguidoresService segService = new SeguidoresService();
			usuarioSegue.setUsuario(user);
			usuarioSegue.setIdSeguidor(idSeguido);
			segService.cadastrar(usuarioSegue);
			
			out.print("SegueSucesso");
		}
		else if(action.equals("deixarSeguir")) {
			Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogado");
			int idSeguido = Integer.parseInt(request.getParameter("idSeguido"));			
			
			Seguidores usuarioSegue = new Seguidores();
			SeguidoresService segService = new SeguidoresService();
			usuarioSegue.setUsuario(user);
			usuarioSegue.setIdSeguidor(idSeguido);
			segService.excluir(usuarioSegue);
			
			out.print("deixarSegueSucesso");
		}
	}
}

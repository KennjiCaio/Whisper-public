package br.usjt.web.whisper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.whisper.model.Usuario;
import br.usjt.web.whisper.service.UsuarioService;

/**
 * Servlet implementation class BuscaUsuario
 */
@WebServlet({ "/BuscaUsuario", "/Busca.do" })
public class BuscaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String nick = request.getParameter("nick");
		if(action.equals("buscaNick"))
		{
			UsuarioService uService = new UsuarioService();
			ArrayList <Usuario> lista = uService.consultaNick(nick);
			PrintWriter out = response.getWriter();
			
			for (Usuario user : lista)
			{
				out.print(
				"<div class=\"media text-muted pt-3\">\r\n" + 
				"	<img class=\"mr-3 align-self-start mr-3\" src='"+user.getFoto()+"' alt=\"\" width=\"48\" height=\"48\">\r\n" + 
				"	<title>Placeholder</title><rect width=\"100%\" height=\"100%\"\r\n" + 
				"			fill=\"#007bff\"></rect>\r\n" + 
				"	<div\r\n" + 
				"		class=\"media-body pb-3 mb-0 small lh-125 border-bottom border-gray\">\r\n" + 
				"			<div class=\"d-flex justify-content-between align-items-center w-100\">\r\n" + 
				"				<strong class=\"text-gray-dark\">"+ user.getNome()+"</strong>" +
				"				<a href='perfilusuario.jsp?id="+user.getId()+"'>Ver Perfil</a>" +
				"			</div>\r\n" + 
				"			<span class=\"d-block\">" + user.getNickname() +"</span>\r\n" + 
				"	</div>\r\n" + 
				"</div>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

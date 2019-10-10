package br.usjt.web.whisper.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.web.whisper.model.Comentario;
import br.usjt.web.whisper.model.CurtidaComentario;
import br.usjt.web.whisper.model.CurtidaPost;
import br.usjt.web.whisper.model.Post;
import br.usjt.web.whisper.model.SubComentario;
import br.usjt.web.whisper.model.Usuario;
import br.usjt.web.whisper.service.ComentarioService;
import br.usjt.web.whisper.service.CurtidaComentarioService;
import br.usjt.web.whisper.service.CurtidaPostService;
import br.usjt.web.whisper.service.PostService;
import br.usjt.web.whisper.service.SubComentarioService;

@WebServlet("/Curtida.do")
public class Curtida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogado");
		
		String action = request.getParameter("action");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(action.equals("curtirPost")) {
			int idPost = Integer.parseInt(request.getParameter("idPost"));
			PostService postService = new PostService();
			CurtidaPostService curtPostServ = new CurtidaPostService();
			CurtidaPost curtPost = new CurtidaPost();
			
			Post post = postService.consultar(idPost);
			int curtidas = post.getCurtidas();
			curtidas++;
			post.setCurtidas(curtidas);
			postService.editar(post);
			
			curtPost.setPost(post);
			curtPost.setUsuario(user);
			curtPostServ.cadastraCurtida(curtPost);
			
			//out.print("curtidaSucesso");
		}
		else if(action.equals("curtirComentario")) {
			int idComentario = Integer.parseInt(request.getParameter("idComentario"));
			ComentarioService comService = new ComentarioService();
			CurtidaComentarioService curtComServ = new CurtidaComentarioService();
			CurtidaComentario curtCom = new CurtidaComentario();
			
			Comentario comentario = comService.consultar(idComentario);
			int curtidas = comentario.getCurtidasComent();
			curtidas++;
			comentario.setCurtidasComent(curtidas);
			comService.editar(comentario);
			
			curtCom.setComentario(comentario);
			curtCom.setUsuario(user);
			curtComServ.cadastraCurtida(curtCom);
			
			//out.print("curtidaSucesso");
			
		}
		else if(action.equals("curtirSubComent")) {
			int idSubComentario = Integer.parseInt(request.getParameter("idSubComentario"));
			SubComentarioService subComService = new SubComentarioService();
			ComentarioService comService = new ComentarioService();
			
			SubComentario subCom = subComService.consultarSubComentario(idSubComentario);
			int curtidas = subCom.getComentario().getCurtidasComent();
			curtidas++;
			subCom.getComentario().setCurtidasComent(curtidas);
			comService.editar(subCom.getComentario());
		}
		else if(action.equals("descurtirPost")) {
			int idPost = Integer.parseInt(request.getParameter("idPost"));
			PostService postService = new PostService();
			CurtidaPostService curtPostServ = new CurtidaPostService();
			CurtidaPost curtPost = new CurtidaPost();
			
			Post post = postService.consultar(idPost);
			int curtidas = post.getCurtidas();
			curtidas--;
			post.setCurtidas(curtidas);
			postService.editar(post);
			
			curtPost.setPost(post);
			curtPost.setUsuario(user);
			curtPostServ.excluirCurtida(curtPost);
			
			out.print("descurtidaSucesso");
		}
		else if(action.equals("descurtirComentario")) {
			int idComentario = Integer.parseInt(request.getParameter("idComentario"));
			ComentarioService comService = new ComentarioService();
			CurtidaComentarioService curtComServ = new CurtidaComentarioService();
			CurtidaComentario curtCom = new CurtidaComentario();
			
			Comentario comentario = comService.consultar(idComentario);
			int curtidas = comentario.getCurtidasComent();
			curtidas--;
			comentario.setCurtidasComent(curtidas);
			comService.editar(comentario);
			
			curtCom.setComentario(comentario);
			curtCom.setUsuario(user);
			curtComServ.excluirCurtida(curtCom);
			
			out.print("desccurtidaSucesso");
		}
		else if(action.equals("descurtirSubComent")) {
			int idSubComentario = Integer.parseInt(request.getParameter("idSubComentario"));
			SubComentarioService subComService = new SubComentarioService();
			ComentarioService comService = new ComentarioService();
			
			SubComentario subCom = subComService.consultarSubComentario(idSubComentario);
			int curtidas = subCom.getComentario().getCurtidasComent();
			curtidas--;
			subCom.getComentario().setCurtidasComent(curtidas);
			comService.editar(subCom.getComentario());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

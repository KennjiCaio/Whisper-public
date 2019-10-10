package br.usjt.web.whisper.service;

import java.util.ArrayList;

import br.usjt.web.whisper.dao.PostDAO;
import br.usjt.web.whisper.model.Post;

public class PostService {
	
	Post post;
	PostDAO postDAO;
	
	public PostService() {
		this.postDAO = new PostDAO();
	}
	
	public void cadastrar(Post post) {
		this.postDAO.cadastrar(post);
	}
	
	public void editar(Post post) {
		this.postDAO.editar(post);
	}
	
	public Post consultar(int id) {
		return this.postDAO.consultar(id);
	}
	
	public void excluir(int id) {
		this.postDAO.excluir(id);
	}
	
	public ArrayList<Post> consultaPostSeguidores(int idUsuario){
		return this.postDAO.consultaPostSeguidores(idUsuario);
	}
	
	public ArrayList<Post> consultaFeedUsuario(int idUsuario){
		return this.postDAO.consultaFeedUsuario(idUsuario);
	}
	
}

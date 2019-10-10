package br.usjt.web.whisper.service;

import java.util.ArrayList;

import br.usjt.web.whisper.dao.ComentarioDAO;
import br.usjt.web.whisper.model.Comentario;

public class ComentarioService {
	
	Comentario comentario;
	ComentarioDAO comentarioDAO;
	
	public ComentarioService() {
		this.comentarioDAO = new ComentarioDAO();
	}
	
	public int cadastrar(Comentario comentario) {
		return this.comentarioDAO.cadastrar(comentario);
	}
	
	public void editar(Comentario comentario) {
		this.comentarioDAO.editar(comentario);
	}
	
	public Comentario consultar(int id) {
		return this.comentarioDAO.consultar(id);
	}
	
	public void excluir(int id) {
		this.comentarioDAO.excluir(id);
	}
	
	public ArrayList<Comentario> listaComentariosPost(int idPost){
		return comentarioDAO.listaComentariosPost(idPost);
	}
	
	public int qtdComentario(int idPost) {
		return comentarioDAO.qtdComentario(idPost);
	}
	
}

package br.usjt.web.whisper.service;

import br.usjt.web.whisper.dao.SubComentarioDAO;
import br.usjt.web.whisper.model.SubComentario;

public class SubComentarioService {
	
	SubComentario subComentario;
	SubComentarioDAO subComentarioDAO;
	
	public SubComentarioService() {
		this.subComentarioDAO = new SubComentarioDAO();
	}
	
	public void cadastrar(SubComentario subComentario) {
		this.subComentarioDAO.cadastar(subComentario);
	}
	
	public void excluir(SubComentario subComentario) {
		this.subComentarioDAO.excluir(subComentario);
	}
	
	public SubComentario consultarSubComentario(int id) {
		return this.subComentarioDAO.consultarSubComentario(id);
	}
}

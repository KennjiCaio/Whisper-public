package br.usjt.web.whisper.service;

import br.usjt.web.whisper.dao.SeguidoresDAO;
import br.usjt.web.whisper.model.Seguidores;

public class SeguidoresService {
	
	Seguidores seguidores;
	SeguidoresDAO seguidoresDAO;
	
	public SeguidoresService() {
		this.seguidoresDAO = new SeguidoresDAO();
	}
	
	public void cadastrar(Seguidores seguidores) {
		this.seguidoresDAO.cadastrar(seguidores);
	}
	
	public void excluir(Seguidores seguidores) {
		this.seguidoresDAO.excluir(seguidores);
	}
	
	public boolean consultaSeguidor(Seguidores seguidores) {
		return this.seguidoresDAO.consultaSeguidor(seguidores);
	}
	
	public int qtdSegue(int idUsuario) {
		return this.seguidoresDAO.qtdSegue(idUsuario);
	}
	
	public int qtdSeguidores(int idUsuario) {
		return this.seguidoresDAO.qtdSeguidores(idUsuario);
	}
	
}

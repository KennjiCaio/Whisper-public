package br.usjt.web.whisper.service;

import br.usjt.web.whisper.dao.CurtidaComentarioDAO;
import br.usjt.web.whisper.model.CurtidaComentario;

public class CurtidaComentarioService {
	
	CurtidaComentario curtidaCom;
	CurtidaComentarioDAO curtidaComDAO;
	
	public CurtidaComentarioService() {
		this.curtidaComDAO = new CurtidaComentarioDAO();
	}
	
	public void cadastraCurtida(CurtidaComentario curtiCom) {
		this.curtidaComDAO.cadastraCurtida(curtiCom);
	}
	
	public void excluirCurtida(CurtidaComentario curtiCom) {
		this.curtidaComDAO.excluirCurtida(curtiCom);
	}
	
	public boolean consultaCurtida(CurtidaComentario curtiCom) {
		return this.curtidaComDAO.consultaCurtida(curtiCom);
	}
}

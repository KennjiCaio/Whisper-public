package br.usjt.web.whisper.service;

import br.usjt.web.whisper.dao.CurtidaPostDAO;
import br.usjt.web.whisper.model.CurtidaPost;

public class CurtidaPostService {
	CurtidaPost curtidaPost;
	CurtidaPostDAO curtidaPostDAO;
	
	public CurtidaPostService() {
		this.curtidaPostDAO = new CurtidaPostDAO();
	}
	
	public void cadastraCurtida(CurtidaPost curtidaPost) {
		this.curtidaPostDAO.cadastraCurtida(curtidaPost);
	}
	
	public void excluirCurtida(CurtidaPost curtidaPost) {
		this.curtidaPostDAO.excluirCurtida(curtidaPost);
	}
	
	public boolean consultaCurtida(CurtidaPost curtidaPost) {
		return this.curtidaPostDAO.consultaCurtida(curtidaPost);
	}
}
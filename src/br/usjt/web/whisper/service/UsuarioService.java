package br.usjt.web.whisper.service;

import java.util.ArrayList;

import br.usjt.web.whisper.dao.UsuarioDAO;
import br.usjt.web.whisper.model.Usuario;

public class UsuarioService {
	
	Usuario usuario;
	UsuarioDAO usuarioDAO;
	
	public UsuarioService() {
		this.usuarioDAO = new UsuarioDAO();
	}
	
	public void cadastrar(Usuario usuario){
		this.usuarioDAO.cadastrar(usuario);
	}
	
	public void alterar(Usuario usuario) {
		this.usuarioDAO.alterar(usuario);
	}
	
	public Usuario consultar(int id) {
		return this.usuarioDAO.consultar(id);
	}
	
	public void excluir(int id) {
		this.usuarioDAO.excluir(id);
	}
	
	public Usuario consultaLogin(String email) {
		return this.usuarioDAO.consultarLogin(email);
	}
	
	public boolean validaNick(String nick) {
		return this.usuarioDAO.validaNick(nick);
	}
	
	public boolean validaEmail(String email) {
		return this.usuarioDAO.validaEmail(email);
	}
	public ArrayList<Usuario> consultaNick(String nick)
	{
		return this.usuarioDAO.consultaNick(nick);
	}

}

package br.usjt.web.whisper.model;

public class Seguidores {

	private Usuario usuario;
	private int idSeguidor;

	public Seguidores() {
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getIdSeguidor() {
		return idSeguidor;
	}

	public void setIdSeguidor(int idSeguidor) {
		this.idSeguidor = idSeguidor;
	}

}

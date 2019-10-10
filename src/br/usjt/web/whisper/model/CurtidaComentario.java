package br.usjt.web.whisper.model;

public class CurtidaComentario {
	
	private Comentario comentario;
	private Usuario usuario;
	
	public CurtidaComentario() {
		
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}

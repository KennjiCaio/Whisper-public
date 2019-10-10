package br.usjt.web.whisper.model;

public class SubComentario {

	private Comentario comentario;
	private int idComPrincipal;
	
	public SubComentario() {
		
	}
	
	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public int getIdComPrincipal() {
		return idComPrincipal;
	}

	public void setIdComPrincipal(int idComPrincipal) {
		this.idComPrincipal = idComPrincipal;
	}

}

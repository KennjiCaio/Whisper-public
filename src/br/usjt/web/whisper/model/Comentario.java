package br.usjt.web.whisper.model;

public class Comentario {

	private int id;
	private String texto;
	private String imagem;
	private int curtidasComent;
	private Usuario usuario;
	private Post post;
	
	public Comentario() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public int getCurtidasComent() {
		return curtidasComent;
	}

	public void setCurtidasComent(int curtidasComent) {
		this.curtidasComent = curtidasComent;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}

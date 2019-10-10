package br.usjt.web.whisper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.whisper.model.Comentario;
import br.usjt.web.whisper.model.Post;
import br.usjt.web.whisper.model.SubComentario;
import br.usjt.web.whisper.model.Usuario;

public class SubComentarioDAO {
	
	Connection conexao;
	
	public SubComentarioDAO() {
		
	}
	
	public void cadastar(SubComentario subComentario) {
		String sqlInsert = "INSERT INTO subcomentario (idComentario, idSubComentario) VALUES (?, ?)";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlInsert);
			ps.setInt(1, subComentario.getIdComPrincipal());
			ps.setInt(2, subComentario.getComentario().getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(SubComentario subComentario) {
		String sqlDelete = "DELETE subcomentario WHERE idComentario=? AND idSubComentario=?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlDelete);
			ps.setInt(1, subComentario.getIdComPrincipal());
			ps.setInt(2, subComentario.getComentario().getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public SubComentario consultarSubComentario(int id) {
		String sqlSelect = "SELECT "
				+ " c.id,"
				+ " c.texto"
				+ " c.imagem"
				+ " c.curtidasComent"
				+ " c.idPost"
				+ " c.idUsuario"
				+ " sc.idComentario"
				+ " FROM comentario c"
				+ " INNER JOIN subcomentario sc"
				+ " ON c.id = sc.idSubComentario"
				+ " WHERE sc.idSubComentario = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				SubComentario subComentario = new SubComentario();
				Comentario comentario = new Comentario();
				Post post = new Post();
				Usuario usuario = new Usuario();
				comentario.setId(rs.getInt(1));
				comentario.setTexto(rs.getString(2));
				comentario.setImagem(rs.getString(3));
				comentario.setCurtidasComent(rs.getInt(4));
				post.setId(rs.getInt(5));
				comentario.setPost(post);
				usuario.setId(rs.getInt(6));
				comentario.setUsuario(usuario);
				subComentario.setComentario(comentario);
				subComentario.setIdComPrincipal(rs.getInt(7));
				return subComentario;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

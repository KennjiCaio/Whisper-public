package br.usjt.web.whisper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.whisper.model.Comentario;
import br.usjt.web.whisper.model.Post;
import br.usjt.web.whisper.model.Usuario;

public class ComentarioDAO {
	
	Connection conexao;
	
	public ComentarioDAO() {
	}
	
	public int cadastrar(Comentario comentario) {
		String sqlInsert = "INSERT INTO comentario (texto, imagem, idPost, idUsuario) VALUES (?, ?, ?, ?)";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, comentario.getTexto());
			ps.setString(2, comentario.getImagem());
			ps.setInt(3, comentario.getPost().getId());
			ps.setInt(4, comentario.getUsuario().getId());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int idGerado = rs.getInt(1);
				return idGerado;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void editar(Comentario comentario) {
		String sqlUpdate = "UPDATE comentario SET texto=?, imagem=?, curtidasComent=? WHERE idPost = ? AND idUsuario = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlUpdate);
			ps.setString(1, comentario.getTexto());
			ps.setString(2, comentario.getImagem());
			ps.setInt(3, comentario.getCurtidasComent());
			ps.setInt(4, comentario.getPost().getId());
			ps.setInt(5, comentario.getUsuario().getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Comentario consultar(int id) {
		String sqlSelect = "SELECT * FROM comentario WHERE id = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, id);
			
			try (ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
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
					return comentario;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void excluir(int id) {
		String sqlDelete = "DELETE comentario WHERE id = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlDelete);
			ps.setInt(1, id);
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Comentario> listaComentariosPost(int idPost) {
		String sqlSelect = "SELECT"
				+ "	c.id,"
				+ " c.texto,"
				+ " c.imagem,"
				+ " c.curtidasComent,"
				+ " c.idPost,"
				+ "	seg.id,"
				+ " seg.email,"
				+ " seg.nome,"
				+ " seg.nickname,"
				+ " seg.foto,"
				+ " seg.flAtivo"
				+ " FROM comentario c"
				+ " INNER JOIN usuario seg"
				+ " ON c.idUsuario = seg.id"
				+ " WHERE idPost = ?";
		ArrayList<Comentario> lista = new ArrayList<>();
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, idPost);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
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
				usuario.setEmail(rs.getString(7));
				usuario.setNome(rs.getString(8));
				usuario.setNickname(rs.getString(9));
				usuario.setFoto(rs.getString(10));
				usuario.setFlAtivo(rs.getBoolean(11));
				comentario.setUsuario(usuario);
				lista.add(comentario);
			}
			return lista;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public int qtdComentario(int idPost) {
		String sqlSelect = "SELECT COUNT(*) FROM comentario WHERE idPost = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, idPost);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int qtd = rs.getInt(1);
				return qtd;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}









package br.usjt.web.whisper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.whisper.model.Post;
import br.usjt.web.whisper.model.Usuario;

public class PostDAO {
	
	Connection conexao;
	
	public PostDAO() {
	}
	
	public void cadastrar(Post post) {
		String sqlInsert = "INSERT INTO post (descricao, imagem, id_usuario) VALUES (?, ?, ?)";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlInsert);
			ps.setString(1, post.getDescricao());
			ps.setString(2, post.getImagem());
			ps.setInt(3, post.getUsuario().getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(Post post) {
		String sqlUpdate = "UPDATE post SET descricao=?, imagem=?, curtidas=?, id_usuario=? WHERE id=?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlUpdate);
			ps.setString(1, post.getDescricao());
			ps.setString(2, post.getImagem());
			ps.setInt(3, post.getCurtidas());
			ps.setInt(4, post.getUsuario().getId());
			ps.setInt(5, post.getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Post consultar(int id) {
		String sqlSelect = "SELECT * FROM post WHERE id = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, id);
			
			try (ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					Post post = new Post();
					Usuario usuario = new Usuario();
					post.setId(rs.getInt("id"));
					post.setDescricao(rs.getString("descricao"));
					post.setImagem(rs.getString("imagem"));
					post.setCurtidas(rs.getInt("curtidas"));
					usuario.setId(rs.getInt("id_usuario"));
					post.setUsuario(usuario);
					return post;
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
		String sqlDelete = "DELETE post WHERE id = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlDelete);
			ps.setInt(1, id);
			ps.execute();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Post> consultaPostSeguidores(int idUsuario){
		String sqlSelect = 
				"SELECT"
				+ " p.id,"
				+ " p.descricao,"
				+ " p.imagem,"
				+ " p.curtidas,"
				+ " seg.id,"
				+ " seg.email,"
				+ " seg.nome,"
				+ " seg.nickname,"
				+ " seg.foto,"
				+ " seg.flAtivo"
				+ " FROM post p"
				+ " INNER JOIN usuario seg"
				+ " ON p.id_usuario = seg.id"
				+ " INNER JOIN seguidores s"
				+ " ON seg.id = s.idSeguidor"
				+ " INNER JOIN usuario u"
				+ " ON u.id = s.idUsuario"
				+ " WHERE u.id = ?"
				+ " ORDER BY p.id DESC";
		ArrayList<Post> lista =  new ArrayList<>();
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, idUsuario);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Post post = new Post();
				Usuario usuario = new Usuario();
				post.setId(rs.getInt(1));
				post.setDescricao(rs.getString(2));
				post.setImagem(rs.getString(3));
				post.setCurtidas(rs.getInt(4));
				usuario.setId(rs.getInt(5));
				usuario.setEmail(rs.getString(6));
				usuario.setNome(rs.getString(7));
				usuario.setNickname(rs.getString(8));
				usuario.setFoto(rs.getString(9));
				usuario.setFlAtivo(rs.getBoolean(10));
				post.setUsuario(usuario);
				lista.add(post);
			}
			return lista;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Post> consultaFeedUsuario(int idUsuario){
		String sqlSelect = 
				"SELECT * FROM post WHERE id_usuario = ? ORDER BY id DESC";
		ArrayList<Post> lista =  new ArrayList<>();
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, idUsuario);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Post post = new Post();
				Usuario usuario = new Usuario();
				post.setId(rs.getInt(1));
				post.setDescricao(rs.getString(2));
				post.setImagem(rs.getString(3));
				post.setCurtidas(rs.getInt(4));
				usuario.setId(rs.getInt(5));
				post.setUsuario(usuario);
				lista.add(post);
			}
			return lista;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}














package br.usjt.web.whisper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.whisper.model.Usuario;

public class UsuarioDAO {
	
	Connection conexao;
	
	public UsuarioDAO() {
	}
	
	public void cadastrar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario (email, nome, senha, nickname, dtNascimento) VALUES (?, ?, ?, ?, ?)";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlInsert);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getNickname());
			ps.setDate(5, usuario.getDtNascimento());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET nome=?, senha=?, foto=? WHERE id=?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlUpdate);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getFoto());
			ps.setInt(4, usuario.getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario consultar(int id) {
		String sqlSelect = "SELECT * FROM usuario WHERE id = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, id);
			
			try (ResultSet rs = ps.executeQuery();){
				if(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setEmail(rs.getString("email"));
					usuario.setNome(rs.getString("nome"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setFone(rs.getInt("fone"));
					usuario.setNickname(rs.getString("nickname"));
					usuario.setFoto(rs.getString("foto"));
					usuario.setDtNascimento(rs.getDate("dtNascimento"));
					usuario.setBiografia(rs.getString("biografia"));
					usuario.setFlAtivo(rs.getBoolean("flAtivo"));
					return usuario;
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
		String sqlUpdate = "UPDATE usuario SET flAtivo = ? WHERE id = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlUpdate);
			ps.setInt(1, id);
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario consultarLogin(String email) {
		String sqlSelect = "SELECT * FROM usuario WHERE email = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setString(1, email);
			
			try (ResultSet rs = ps.executeQuery();){
				if(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setEmail(rs.getString("email"));
					usuario.setNome(rs.getString("nome"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setFone(rs.getInt("fone"));
					usuario.setNickname(rs.getString("nickname"));
					usuario.setFoto(rs.getString("foto"));
					usuario.setDtNascimento(rs.getDate("dtNascimento"));
					usuario.setBiografia(rs.getString("biografia"));
					usuario.setFlAtivo(rs.getBoolean("flAtivo"));
					return usuario;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean validaNick(String nick) {
		String sqlSelect = "SELECT nickname FROM usuario WHERE nickname = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setString(1, nick);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return true;
		}
		return true;
	}
	
	public boolean validaEmail(String email) {
		String sqlSelect = "SELECT email FROM usuario WHERE email = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return true;
		}
		return true;
	}
	
	public ArrayList<Usuario> consultaUsuarioSegue(int idUsuario) {
		String sqlSelect =
				"SELECT"
				+ " seguidor.id,"
				+ "	seguidor.email,"
				+ "	seguidor.nome,"
				+ "	seguidor.nickname,"
				+ "	seguidor.foto,"
				+ "	seguidor.flAtivo"
				+ " FROM usuario seguidor"
				+ " INNER JOIN seguidores s"
				+ " ON seguidor.id = s.idSeguidor"
				+ " INNER JOIN usuario u"
				+ " ON u.id = s.idUsuario"
				+ " WHERE u.id = ?";
		ArrayList<Usuario> lista = new ArrayList<>();
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, idUsuario);
			
			try (ResultSet rs = ps.executeQuery();){
				if(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt(1));
					usuario.setEmail(rs.getString(2));
					usuario.setNome(rs.getString(3));
					usuario.setNickname(rs.getString(4));
					usuario.setFoto(rs.getString(5));
					usuario.setFlAtivo(rs.getBoolean(6));
					lista.add(usuario);
				}
				return lista;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Usuario> consultaSeguidores(int idUsuario) {
		String sqlSelect =
				"SELECT"
				+ "	seguidor.id,"
				+ "	seguidor.email,"
				+ "	seguidor.nome,"
				+ "	seguidor.nickname,"
				+ "	seguidor.foto,"
				+ "	seguidor.flAtivo"
				+ " FROM usuario seguidor"
				+ " INNER JOIN seguidores s"
				+ " ON seguidor.id = s.idUsuario"
				+ " INNER JOIN usuario u"
				+ " ON u.id = s.idSeguidor"
				+ " WHERE u.id = ?";
		ArrayList<Usuario> lista = new ArrayList<>();
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, idUsuario);
			
			try (ResultSet rs = ps.executeQuery();){
				if(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt(1));
					usuario.setEmail(rs.getString(2));
					usuario.setNome(rs.getString(3));
					usuario.setNickname(rs.getString(4));
					usuario.setFoto(rs.getString(5));
					usuario.setFlAtivo(rs.getBoolean(6));
					lista.add(usuario);
				}
				return lista;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Usuario> consultaNick(String nick) {
		String sqlSelect =
				"SELECT id, email, nome, nickname, foto, flAtivo FROM usuario  WHERE nickname LIKE ?";
		ArrayList<Usuario> lista = new ArrayList<>();
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			String nickLike = nick + "%";
			ps.setString(1, nickLike);
			
			try (ResultSet rs = ps.executeQuery();){
				if(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt(1));
					usuario.setEmail(rs.getString(2));
					usuario.setNome(rs.getString(3));
					usuario.setNickname(rs.getString(4));
					usuario.setFoto(rs.getString(5));
					usuario.setFlAtivo(rs.getBoolean(6));
					lista.add(usuario);
				}
				return lista;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
}

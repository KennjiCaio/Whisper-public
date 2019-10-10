package br.usjt.web.whisper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.whisper.model.Seguidores;

public class SeguidoresDAO {
	
	Connection conexao;
	
	public SeguidoresDAO() {
	}
	
	public void cadastrar(Seguidores seguidores) {
		String sqlInsert = "INSERT INTO seguidores (idUsuario, idSeguidor) VALUES (?, ?)";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlInsert);
			ps.setInt(1, seguidores.getUsuario().getId());
			ps.setInt(2, seguidores.getIdSeguidor());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Seguidores seguidores) {
		String sqlDelete = "DELETE FROM seguidores WHERE idUsuario = ? AND idSeguidor = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlDelete);
			ps.setInt(1, seguidores.getUsuario().getId());
			ps.setInt(2, seguidores.getIdSeguidor());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean consultaSeguidor(Seguidores seguidores) {
		String sqlSelect = "SELECT * FROM seguidores WHERE idUsuario = ? AND idSeguidor = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, seguidores.getUsuario().getId());
			ps.setInt(2, seguidores.getIdSeguidor());
			
			try(ResultSet rs = ps.executeQuery();){
				if(rs.next()) {
					return true;
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public int qtdSegue(int idUsuario) {
		String sqlSelect = "SELECT COUNT(*) FROM seguidores WHERE idUsuario = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, idUsuario);
			
			try (ResultSet rs = ps.executeQuery();){
				if(rs.next()) {
					int qtd = rs.getInt(1);
					return qtd;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	public int qtdSeguidores(int idUsuario) {
		String sqlSelect = "SELECT COUNT(*) FROM seguidores WHERE idSeguidor = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, idUsuario);
			
			try (ResultSet rs = ps.executeQuery();){
				if(rs.next()) {
					int qtd = rs.getInt(1);
					return qtd;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}















package br.usjt.web.whisper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.whisper.model.CurtidaComentario;

public class CurtidaComentarioDAO {
	
	Connection conexao;
	
	public CurtidaComentarioDAO() {
		
	}
	
	public void cadastraCurtida(CurtidaComentario curtiCom) {
		String sqlInsert = "INSERT INTO curtidacomentario (idComentario, idUsuario) VALUES (?, ?)";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlInsert);
			ps.setInt(1, curtiCom.getComentario().getId());
			ps.setInt(2, curtiCom.getUsuario().getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirCurtida(CurtidaComentario curtiCom) {
		String sqlDelete = "DELETE FROM curtidacomentario WHERE idComentario = ? AND idUsuario = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlDelete);
			ps.setInt(1, curtiCom.getComentario().getId());
			ps.setInt(2, curtiCom.getUsuario().getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean consultaCurtida(CurtidaComentario curtiCom) {
		String sqlSelect = "SELECT * FROM curtidacomentario WHERE idComentario = ? AND idUsuario = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, curtiCom.getComentario().getId());
			ps.setInt(2, curtiCom.getUsuario().getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

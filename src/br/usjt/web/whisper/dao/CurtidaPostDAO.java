package br.usjt.web.whisper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.web.whisper.model.CurtidaPost;

public class CurtidaPostDAO {
	
	Connection conexao;
	
	public CurtidaPostDAO() {
		
	}
	
	public void cadastraCurtida(CurtidaPost curtiPost) {
		String sqlInsert = "INSERT INTO curtidapost (idPost, idUsuario) VALUES (?, ?)";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlInsert);
			ps.setInt(1, curtiPost.getPost().getId());
			ps.setInt(2, curtiPost.getUsuario().getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirCurtida(CurtidaPost curtiPost) {
		String sqlDelete = "DELETE FROM curtidapost WHERE idPost = ? AND idUsuario = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlDelete);
			ps.setInt(1, curtiPost.getPost().getId());
			ps.setInt(2, curtiPost.getUsuario().getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean consultaCurtida(CurtidaPost curtiPost) {
		String sqlSelect = "SELECT * FROM curtidapost WHERE idPost = ? AND idUsuario = ?";
		try {
			this.conexao = Conexao.conectar();
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1, curtiPost.getPost().getId());
			ps.setInt(2, curtiPost.getUsuario().getId());
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

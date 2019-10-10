package br.usjt.web.whisper.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	//COLOCAR NOME DO BANCO DE DADOS PARA A CONEXÃO
	//USER E SENHA!!!
	public static Connection conectar() throws SQLException{
		String url = "jdbc:mysql://localhost/bd_whisper?useTimezone=true&serverTimezone=UTC";
		String user = "";
		String senha = "";
		return DriverManager.getConnection(url, user, senha);
	}
	
	public static void desconectar(Connection conexao) throws SQLException {
		conexao.close();
	}
}

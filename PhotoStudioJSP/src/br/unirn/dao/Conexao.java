package br.unirn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConexao() throws SQLException {
		String serverName = "localhost";
		String mydatabase = "BancoFinal";
		String url = "jdbc:postgresql://" + serverName + "/" + mydatabase;
		String username = "postgres";
		String password = "280394";

		try {
			Class.forName("org.postgresql.Driver");

			System.out.println("Conectado no banco");
			return DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			System.out.println("N�o Conectado no banco");

			throw new SQLException(e.getMessage());
		}

	}
	
	
	/**
	 * TESTE DE CONEX�O !!!!
	public static void main(String[] args) {
		

		Connection conexao;
		try {
			conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
}

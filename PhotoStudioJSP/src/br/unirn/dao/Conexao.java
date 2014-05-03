package br.unirn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.unirn.dominio.Estado;

public class Conexao {

	public static Connection getConexao() throws SQLException {
		String serverName = "localhost";
		String mydatabase = "studio";
		String url = "jdbc:postgresql://" + serverName + "/" + mydatabase;
		String username = "postgres";
		String password = "lkug941312";

		try {
			Class.forName("org.postgresql.Driver");

			System.out.println("Conectado no banco");
			return DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			System.out.println("Não Conectado no banco"+e.getMessage()+" "+e.getCause()+" "+e.getLocalizedMessage());

			throw new SQLException(e.getMessage());
		}

	}
	
	
	
}

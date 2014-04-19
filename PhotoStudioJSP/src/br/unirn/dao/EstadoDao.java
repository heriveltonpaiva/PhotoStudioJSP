package br.unirn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.unirn.dominio.Estado;

public class EstadoDao  {

	private Connection conexao;
	
	public EstadoDao() {
	
	try {
		this.conexao = Conexao.getConexao();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	
	public void insert(Estado estado) throws SQLException {
		 //PREPARA CONEXÃO
        String slq = "INSERT INTO estado(descricao)"
                + "values(?)";

        PreparedStatement stmt = conexao.prepareStatement(slq);

        // SETANDO OS VALORES 
        stmt.setString(1, estado.getDescricao());
       

        //executa o codigo SQL
        stmt.execute();
        stmt.close();
		
	}

	
	public void update(Estado entity) {
		// TODO Auto-generated method stub
		
	}


	public void delete(Estado entity) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Estado> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Estado findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

package br.unirn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Contato;
import br.unirn.dominio.Estado;

public class ContatoDao{
	private Connection conexao;
	
	public ContatoDao() {
	
		try {
			this.conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private int getID(){
		int result = 0;
		String sql = "select nextval('contato_id_contato_seq')";
		
		PreparedStatement stmt=null;
		try {
			stmt = conexao.prepareStatement(sql);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}	
			
		ResultSet rs =null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while(rs.next()){
			result = rs.getInt("nextval");
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public void insert(Contato c) throws SQLException {
		 //PREPARA CONEXÃO
		   int id = getID();
	       String slq = "INSERT INTO contato(id_contato, telefone, celular, email)VALUES (?, ?, ?, ?);";
	               

	       PreparedStatement stmt = conexao.prepareStatement(slq);

	       // SETANDO OS VALORES
	       stmt.setInt(1, id);
	       stmt.setString(2, c.getTelefone());
	       stmt.setString(3, c.getCelular());
	       stmt.setString(4, c.getEmail());
	       
	       c.setIdContato(id);

	       //executa o codigo SQL
	       stmt.execute();
	       stmt.close();
	}

	
	public void update(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Contato> findAll() throws SQLException {
		String sql = "SELECT*FROM contato";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        // criando arraylist 
        List<Contato> Lista = new ArrayList<Contato>();
        while (rs.next()) {
            // estanciando 
            Contato c1 = new Contato();
            // pegando os objetos 
            c1.setIdContato(rs.getInt("id_contato"));
            c1.setTelefone(rs.getString("telefone"));
            c1.setCelular(rs.getString("celular"));
            c1.setEmail(rs.getString("email"));
            Lista.add(c1);
        }
        rs.close();
        stmt.close();
	return Lista;
	}

	
	public Object findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

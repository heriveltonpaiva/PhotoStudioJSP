package br.unirn.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Album;
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
	
	
	private int getID(){
		int result = 0;
		String sql = "select nextval('estado_id_estado_seq')";
		
		PreparedStatement stmt=null;
		try {
			stmt = conexao.prepareStatement(sql);
		} catch (SQLException e2) {
			System.out.println("Erro na criação do Statement "+e2);
		}	
			
		ResultSet rs =null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e1) {
			System.out.println("Erro na criação do ResultSet "+e1);
		}
		
		try {
			while(rs.next()){
			result = rs.getInt("nextval");
			}
			} catch (SQLException e) {
				System.out.println("Erro na consulta do nextval "+e);
		}
		
		return result;
	}
	
	
	public void insert(Estado estado) throws SQLException {
		 //PREPARA CONEXÃO
		int id = getID();
        String slq = "INSERT INTO estado(id_estado, descricao)"
                + "values(?,?)";

        PreparedStatement stmt = conexao.prepareStatement(slq);

        // SETANDO OS VALORES
        stmt.setInt(1, id);
        stmt.setString(2, estado.getDescricao());
        estado.setIdEstado(id);

        //executa o codigo SQL
        stmt.execute();
        stmt.close();
		
	}

	
	public void update(Estado estado) throws SQLException {
		String sql = "update estado set descricao=? where id_estado=?";
		
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, estado.getDescricao());
			stmt.setInt(2, estado.getIdEstado());
	
			stmt.execute();
			stmt.close();
			
			System.out.println("Alterado com sucesso");
	}



	public void delete(Estado entity) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Estado> findAll() throws SQLException {
		 String sql = "SELECT*FROM estado";
	        PreparedStatement stmt = this.conexao.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        // criando arraylist 
	        List<Estado> Lista = new ArrayList<Estado>();
	        while (rs.next()) {
	            // estanciando 
	            Estado c1 = new Estado();
	            // pegando os objetos 
                c1.setIdEstado(rs.getInt("id_estado"));
	            c1.setDescricao(rs.getString("descricao"));
	            
	            Lista.add(c1);
	        }
	        rs.close();
	        stmt.close();
		return Lista;
	}

	public Estado findById(Integer id) throws SQLException {
		 String sql = "SELECT*FROM estado WHERE id_estado="+id;
	        PreparedStatement stmt = this.conexao.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        // criando arraylist 
	        Estado c1=null;
	        while (rs.next()) {
	            // estanciando 
	             c1 = new Estado();
	            // pegando os objetos 
             c1.setIdEstado(rs.getInt("id_estado"));
	            c1.setDescricao(rs.getString("descricao"));
	            
	          
	        }
	        rs.close();
	        stmt.close();
		return c1;
	}

	

}

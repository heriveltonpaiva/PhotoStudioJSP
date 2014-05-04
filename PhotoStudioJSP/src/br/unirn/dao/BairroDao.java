package br.unirn.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Album;
import br.unirn.dominio.Bairro;
import br.unirn.dominio.Estado;

public class BairroDao {
	private Connection conexao;
	
	public BairroDao() {
	
		try {
			this.conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int getID(){
		int result = 0;
		String sql = "select nextval('bairro_id_bairro_seq')";
		
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
	
	public void insert(Bairro bairro) throws SQLException {
		 //PREPARA CONEXÃO
		   int id = getID();
	       String slq = "INSERT INTO bairro(id_bairro, descricao, id_cidade_cidade)VALUES (?, ?, ?)";
	               

	       PreparedStatement stmt = conexao.prepareStatement(slq);

	       // SETANDO OS VALORES
	       stmt.setInt(1, id);
	       stmt.setString(2, bairro.getDescricao());
	       stmt.setInt(3, bairro.getIdCidadeCidade().getIdCidade());
	       bairro.setIdBairro(id);

	       //executa o codigo SQL
	       stmt.execute();
	       stmt.close();
	}

	
	public void update(Bairro bairro) throws SQLException {
		String sql = "update bairro set descricao=?,id_cidade_cidade=? where id_bairro=?";
		
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, bairro.getDescricao());
			stmt.setInt(2, bairro.getIdCidadeCidade().getIdCidade());
			stmt.setInt(3, bairro.getIdBairro());
	
			stmt.execute();
			stmt.close();
			
			System.out.println("Alterado com sucesso");
	}

	
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Bairro> findAll() throws SQLException {
		 String sql = "SELECT*FROM bairro";
	        PreparedStatement stmt = this.conexao.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        // criando arraylist 
	        List<Bairro> Lista = new ArrayList<Bairro>();
	        while (rs.next()) {
	            // estanciando 
	            Bairro c1 = new Bairro();
	            // pegando os objetos 
                c1.setIdBairro(rs.getInt("id_bairro"));
	            c1.setDescricao(rs.getString("descricao"));
	            
	            Lista.add(c1);
	        }
	        rs.close();
	        stmt.close();
		return Lista;
	}

	
	public Bairro findById(Integer id) throws SQLException {
		
			 String sql = "SELECT*FROM bairro WHERE id_bairro="+id;
		        PreparedStatement stmt = this.conexao.prepareStatement(sql);
		        ResultSet rs = stmt.executeQuery();
		        CidadeDao dao = new CidadeDao();
		        // criando arraylist 
		        Bairro c1=null;
		        while (rs.next()) {
		            // estanciando 
		             c1 = new Bairro();
		            // pegando os objetos 
	                c1.setIdBairro(rs.getInt("id_bairro"));
		            c1.setDescricao(rs.getString("descricao"));
		            c1.setIdCidadeCidade(dao.findById(Integer.parseInt(rs.getString("id_cidade_cidade"))));		            
		        }
		        rs.close();
		        stmt.close();
			return c1;
	
	}

	
	
}

package br.unirn.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Album;
import br.unirn.dominio.Endereco;
import br.unirn.dominio.Estado;

public class EnderecoDao {
	private Connection conexao;
	public EnderecoDao() {
	
		try {
			this.conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int getID(){
		int result = 0;
		String sql = "select nextval('endereco_id_endereco_seq')";
		
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
	public void insert(Endereco e) throws SQLException {
		 //PREPARA CONEXÃO
		   int id = getID();
	       String slq = "INSERT INTO endereco(id_endereco, descricao, numero, cep, complemento, id_bairro_bairro)VALUES (?, ?, ?, ?, ?, ?);";
	               

	       PreparedStatement stmt = conexao.prepareStatement(slq);

	       // SETANDO OS VALORES
	       stmt.setInt(1, id);
	       stmt.setString(2, e.getDescricao());
	       stmt.setInt(3, e.getNumero());
	       stmt.setString(4, e.getCep());
	       stmt.setString(5, e.getComplemento());
	       stmt.setInt(6, e.getIdBairroBairro().getIdBairro());
	       e.setIdEndereco(id);

	       //executa o codigo SQL
	       stmt.execute();
	       stmt.close();
	}

	
	public void update(Endereco endereco) throws SQLException {
		String sql = "update endereco set descricao=?, numero=?, cep=?, complemento=?, id_bairro_bairro=? where id_endereco=?";
		
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, endereco.getDescricao());
			stmt.setInt(2, endereco.getNumero());
			stmt.setString(3, endereco.getCep());
			stmt.setString(4, endereco.getComplemento());
			stmt.setInt(5, endereco.getIdBairroBairro().getIdBairro());
			stmt.setInt(6, endereco.getIdEndereco());
	
			stmt.execute();
			stmt.close();
			
			System.out.println("Alterado com sucesso");
	}


	
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Endereco> findAll() throws SQLException {
		 String sql = "SELECT*FROM endereco";
	        PreparedStatement stmt = this.conexao.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        // criando arraylist 
	        List<Endereco> Lista = new ArrayList<Endereco>();
	        while (rs.next()) {
	            // estanciando 
	            Endereco c1 = new Endereco();
	            // pegando os objetos 
	            
                c1.setIdEndereco(rs.getInt("id_endereco"));
	            c1.setDescricao(rs.getString("descricao"));
	            c1.setCep(rs.getString("cep"));
	            c1.setNumero(rs.getInt("numero"));
	            c1.setComplemento(rs.getString("complemento"));
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

package br.unirn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Cidade;

public class CidadeDao  {
      private Connection conexao;
	public CidadeDao() {

		try {
			this.conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	private int getID(){
		int result = 0;
		String sql = "select nextval('cidade_id_cidade_seq')";
		
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
	
	public void insert(Cidade cidade) throws SQLException {
		 //PREPARA CONEX�O
	   int id = getID();
       String slq = "INSERT INTO cidade(id_cidade, descricao, id_estado_estado) VALUES (?, ?, ?)";
               

       PreparedStatement stmt = conexao.prepareStatement(slq);

       // SETANDO OS VALORES
       stmt.setInt(1, id);
       stmt.setString(2, cidade.getDescricao());
       stmt.setInt(3, cidade.getIdEstadoEstado().getIdEstado());
       cidade.setIdCidade(id);

       //executa o codigo SQL
       stmt.execute();
       stmt.close();
		
	}
	
	public void update(Cidade cidade) throws SQLException {
		String sql = "update cidade set descricao=?,id_estado_estado=? where id_cidade=?";
		
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cidade.getDescricao());
			stmt.setInt(2, cidade.getIdEstadoEstado().getIdEstado());
			stmt.setInt(3, cidade.getIdCidade());
	
			stmt.execute();
			stmt.close();
			
			System.out.println("Alterado com sucesso");
	}
	
	public List<Cidade> findAll() throws SQLException {
		 String sql = "SELECT*FROM cidade";
	        PreparedStatement stmt = this.conexao.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        // criando arraylist 
	        List<Cidade> Lista = new ArrayList<Cidade>();
	        while (rs.next()) {
	            // estanciando 
	            Cidade c1 = new Cidade();
	            // pegando os objetos 
             c1.setIdCidade(rs.getInt("id_cidade"));
	            c1.setDescricao(rs.getString("descricao"));
	            Lista.add(c1);
	        }
	        rs.close();
	        stmt.close();
		return Lista;
	}

	public Cidade findById(Integer id) throws SQLException {
		 String sql = "SELECT*FROM cidade WHERE id_cidade="+id;
	        PreparedStatement stmt = this.conexao.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        EstadoDao dao = new EstadoDao();
	        // criando arraylist 
	        Cidade c1=null;
	        while (rs.next()) {
	            // estanciando 
	            c1 = new Cidade();
	            // pegando os objetos 
                c1.setIdCidade(rs.getInt("id_cidade"));
	            c1.setDescricao(rs.getString("descricao"));
	            c1.setIdEstadoEstado(dao.findById(Integer.parseInt(rs.getString("id_estado_estado"))));
	            
	        }
	        rs.close();
	        stmt.close();
		return c1;
	}
	
	
	
}

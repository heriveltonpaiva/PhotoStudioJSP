package br.unirn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Foto;
import br.unirn.dominio.Gestor;


public class GestorDao {
	private Connection conexao;
	public GestorDao() {

		try {
			this.conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Altera o Login do Gestor e sua Senha
	 * @param gestor
	 * @throws SQLException
	 */
	
	public void update(Gestor gestor) throws SQLException {

      String sql = "UPDATE gestor SET  login=?, senha=? WHERE id_gestor=1";
		
      PreparedStatement stmt= conexao.prepareStatement(sql);
      //seta os valores
     
      stmt.setString(1,gestor.getLogin()); 
      stmt.setString(2, gestor.getSenha());
     
      //executa o código sql
      stmt.execute();     
      stmt.close();
     
      
	}
	
	public List<Gestor> findAll() throws SQLException {
		 String sql = "SELECT*FROM gestor";
	        PreparedStatement stmt = this.conexao.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        // criando arraylist 
	        List<Gestor> Lista = new ArrayList<Gestor>();
	        while (rs.next()) {
	            // estanciando 
	            Gestor f = new Gestor();
	            // pegando os objetos 
               f.setIdGestor(rs.getInt("id_gestor"));
	           f.setLogin(rs.getString("login"));
	           f.setSenha(rs.getString("senha"));
	           
	            Lista.add(f);
	        }
	        rs.close();
	        stmt.close();
		return Lista;
	}
    
}

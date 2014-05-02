package br.unirn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Carrinho;
import br.unirn.dominio.Contato;

public class CarrinhoDao{
	private Connection conexao;
	
	public CarrinhoDao() {
		try {
			this.conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private int getID(){
		int result = 0;
		String sql = "select nextval('carrinho_id_carrinho_seq')";
		
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
	
	public void insert(Carrinho c) throws SQLException {
		//PREPARA CONEX�O
		   int id = getID();
	       String slq = "INSERT INTO carrinho(id_carrinho, id_selecao_selecao, id_cliente_cliente)VALUES (?, ?, ?);";
	               

	       PreparedStatement stmt = conexao.prepareStatement(slq);

	       // SETANDO OS VALORES
	       stmt.setInt(1, id);
	       stmt.setInt(2, c.getSelecao().getIdSelecao());
	       stmt.setInt(3, c.getIdClienteCliente().getIdCliente());
	   
	       c.setIdCarrinho(id);

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

	
	public List<Carrinho> findAll() throws SQLException {
		String sql = "SELECT*FROM carrinho";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        // criando arraylist 
        List<Carrinho> Lista = new ArrayList<Carrinho>();
        while (rs.next()) {
            // estanciando 
            Carrinho c1 = new Carrinho();
            // pegando os objetos 
            c1.setIdCarrinho(rs.getInt("id_carrinho"));
           
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

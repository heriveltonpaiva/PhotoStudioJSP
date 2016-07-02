package br.unirn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Carrinho;
import br.unirn.dominio.Selecao;

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
	       stmt.setInt(2, c.getSelecao());
	       stmt.setInt(3, c.getIdClienteCliente());
	   
	       c.setIdCarrinho(id);

	       //executa o codigo SQL
	       stmt.execute();
	       stmt.close();
	}

	
	public void update(Carrinho carrinho) throws SQLException {
		String sql = "update carrinho set id_selecao_selecao=?, id_cliente_cliente=? where id_carrinho=?";
		
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, carrinho.getSelecao());
			stmt.setInt(2, carrinho.getIdClienteCliente());
			stmt.setInt(3, carrinho.getIdCarrinho());
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Alterado com sucesso");
	}

	
	public void delete(int idCarrinho) throws SQLException {
		String  sql = "delete from carrinho where id_carrinho="+idCarrinho;
		   PreparedStatement stmt = conexao.prepareStatement(sql);
		   stmt.execute();
		   stmt.close();
		
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
            c1.setSelecao(rs.getInt("id_selecao_selecao"));
            Lista.add(c1);
        }
        rs.close();
        stmt.close();
	return Lista;
	}
 
	public List<Carrinho> findAllCarrinho() throws SQLException {
		String sql = "SELECT*FROM carrinho";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        SelecaoDao sel = new SelecaoDao();
        // criando arraylist 
        List<Carrinho> Lista = new ArrayList<Carrinho>();
        while (rs.next()) {
            // estanciando 
            Carrinho c1 = new Carrinho();
            // pegando os objetos 
            c1.setIdCarrinho(rs.getInt("id_carrinho"));
            c1.setSelecao(rs.getInt("id_selecao_selecao"));
            c1.setIdSelecaoSelecao((Selecao)sel.findById(Integer.parseInt(rs.getString("id_selecao_selecao"))));
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

package br.unirn.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Album;
import br.unirn.dominio.Carrinho;
import br.unirn.dominio.Venda;

public class VendaDao {

	private Connection conexao;
	
	public VendaDao() {
	
		try {
			this.conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private int getID(){
		int result = 0;
		String sql = "select nextval('venda_id_venda_seq')";
		
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
	public void insert(Venda v) throws SQLException {
		 //PREPARA CONEXÃO
		   int id = getID();
	       String slq = "INSERT INTO venda(id_venda, descricao, data_venda, id_selecao_selecao) VALUES (?, ?, ?, ?);";
	               

	       PreparedStatement stmt = conexao.prepareStatement(slq);

	       // SETANDO OS VALORES
	       stmt.setInt(1, id);
	       stmt.setString(2, v.getDescricao());
	       stmt.setDate(3, new Date(2014,12,12));
	       stmt.setInt(4, v.getSelecao());
	       
	       v.setIdVenda(id);

	       //executa o codigo SQL
	       stmt.execute();
	       stmt.close();
	}

	public void update(Venda venda) throws SQLException {
		String sql = "update venda set descricao=?, data_venda=?, id_selecao_selecao=? where id_venda=?";
		
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, venda.getDescricao());
			stmt.setDate(2, (Date) venda.getDataVenda());
			stmt.setInt(3, venda.getSelecao().getIdSelecao());
			stmt.setInt(4, venda.getIdVenda());
	
			stmt.execute();
			stmt.close();
			
			System.out.println("Alterado com sucesso");
	}

	
	public List<Venda> findAll() throws SQLException {
		String sql = "SELECT*FROM venda";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        // criando arraylist 
        List<Venda> Lista = new ArrayList<Venda>();
        while (rs.next()) {
            // estanciando 
            Venda v = new Venda();
            // pegando os objetos 
            v.setIdVenda(rs.getInt("id_venda"));
            v.setDescricao(rs.getString("descricao"));
            
            Lista.add(v);
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

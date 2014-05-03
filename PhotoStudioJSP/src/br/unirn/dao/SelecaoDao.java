package br.unirn.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Album;
import br.unirn.dominio.Contato;
import br.unirn.dominio.Selecao;

public class SelecaoDao {


	private Connection conexao;
	
	public SelecaoDao() {
	
		try {
			this.conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private int getID(){
		int result = 0;
		String sql = "select nextval('selecao_id_selecao_seq')";
		
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
	public void insert(Selecao s) throws SQLException {
		//PREPARA CONEXÃO
		   int id = getID();
	       String slq = "INSERT INTO selecao(id_selecao, quantidade, tamanho, valor_venda, " +
	       		"id_foto_foto, id_cliente_cliente, id_fotografo_fotografo)VALUES (?, ?, ?, ?, ?, ?, ?);";
	               

	       PreparedStatement stmt = conexao.prepareStatement(slq);

	       // SETANDO OS VALORES
	       stmt.setInt(1, id);
	       stmt.setInt(2, s.getQuantidade());
	       stmt.setString(3, s.getTamanho());
	       stmt.setDouble(4, s.getValor_venda());
	       stmt.setInt(5, s.getFoto().getIdFoto());
	       stmt.setInt(6, s.getCliente().getIdCliente());
	       stmt.setInt(7, s.getFotografo().getIdFotografo());
	       s.setIdSelecao(id);

	       //executa o codigo SQL
	       stmt.execute();
	       stmt.close();
	}

	
	public void update(Selecao selecao) throws SQLException {
		String sql = "update selecao set quantidade=?, tamanho=?, valor_venda=?, " +
	       		"id_foto_foto=?, id_cliente_cliente=?, id_fotografo_fotografo=? where id_selecao=?";
		
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, selecao.getQuantidade());
			stmt.setString(2, selecao.getTamanho());
			stmt.setDouble(3,selecao.getValor_venda());
			stmt.setInt(4, selecao.getFoto().getIdFoto());
			stmt.setInt(5, selecao.getCliente().getIdCliente());
			stmt.setInt(6, selecao.getFotografo().getIdFotografo());
			stmt.setInt(7, selecao.getIdSelecao());
	
			stmt.execute();
			stmt.close();
			
			System.out.println("Alterado com sucesso");
	}

	
	public List<Selecao> findAll() throws SQLException {
		String sql = "SELECT*FROM selecao";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        // criando arraylist 
        List<Selecao> Lista = new ArrayList<Selecao>();
        while (rs.next()) {
            // estanciando 
            Selecao s = new Selecao();
            // pegando os objetos 
            s.setIdSelecao(rs.getInt("id_selecao"));
            s.setTamanho(rs.getString("tamanho"));
            s.setQuantidade(rs.getInt("quantidade"));
            s.setValor_venda(rs.getDouble("valor_venda"));
            Lista.add(s);
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

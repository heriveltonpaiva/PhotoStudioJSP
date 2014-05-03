package br.unirn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import br.unirn.dominio.Album;
import br.unirn.dominio.Cliente;

public class AlbumDao   {
	private Connection conexao;
	public AlbumDao() {
		try {
			this.conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private int getID(){
		int result = 0;
		String sql = "select nextval('album_id_album_seq')";
		
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

	public void insert(Album album) throws SQLException {
		//PREPARA CONEXÃO
		   int id = getID();
	       String slq = "INSERT INTO album(id_album, descricao, data, obs, id_fotografo_fotografo) VALUES (?, ?, ?, ?, ?);";
	               

	       PreparedStatement stmt = conexao.prepareStatement(slq);

	       // SETANDO OS VALORES
	       stmt.setInt(1, id);
	       stmt.setString(2, album.getDescricao());
	       stmt.setDate(3, new Date(2004,12,12));
	       stmt.setString(4, album.getObs());
	       //TEM QUE TER O FOTOGRAFO PARA CADASTRAR O ALBUM
	       stmt.setInt(5, 3);
	       album.setIdAlbum(id);

	       //executa o codigo SQL
	       stmt.execute();
	       stmt.close();
		
	}

	
	public void update(Album album) throws SQLException {
		String sql = "update album set descricao=?,data=?,obs=?,id_fotografo_fotografo=? where id_album=?";
		
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, album.getDescricao());
			stmt.setDate(2, (Date) album.getData());
			stmt.setString(3, album.getObs());
			stmt.setInt(4, album.getIdFotografoFotografo().getIdFotografo());
			stmt.setInt(5, album.getIdAlbum());
	
			stmt.execute();
			stmt.close();
			
			System.out.println("Alterado com sucesso");
	}

	
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Album> findAll() throws SQLException {
		String sql = "SELECT*FROM album";
	     PreparedStatement stmt = this.conexao.prepareStatement(sql);
	     ResultSet rs = stmt.executeQuery();
	     // criando arraylist 
	     List<Album> Lista = new ArrayList<Album>();
	     while (rs.next()) {
	         // estanciando 
	         Album c1 = new Album();
	         // pegando os objetos 
	         c1.setIdAlbum(rs.getInt("id_album"));
	         c1.setDescricao(rs.getString("descricao"));
	         c1.setObs(rs.getString("obs"));
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

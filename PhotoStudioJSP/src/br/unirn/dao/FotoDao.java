package br.unirn.dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Album;
import br.unirn.dominio.Foto;

public class FotoDao {

	private Connection conexao;
	public FotoDao() {
		try {
			this.conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	private int getID(){
		int result = 0;
		String sql = "select nextval('foto_id_foto_seq')";
		
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
	
	/*
	 * CONVERTE INPUTSTREM PARA BYTES
	 */
	
	public byte[] convertInputStreamToByteArray(InputStream inputStream) {
		byte[] bytes = null;

		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			byte data[] = new byte[1024];
			int count;

			while ((count = inputStream.read(data)) != -1) {
				bos.write(data, 0, count);
			}

			bos.flush();
			bos.close();
			inputStream.close();

			bytes = bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}
	
	public void insert(Foto f) throws SQLException {
		 //PREPARA CONEX�O
		   int id = getID();
	    String slq = "INSERT INTO foto(id_foto, descricao, valor, arquivo, data_upload, obs, foto_nome, contenttype, id_album_album)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	            

	    PreparedStatement stmt = conexao.prepareStatement(slq);
        
	    // SETANDO OS VALORES
	    stmt.setInt(1, id);
	    stmt.setString(2, f.getDescricao());
	    stmt.setDouble(3,f.getValor());
	    stmt.setBytes(4, this.convertInputStreamToByteArray(f.getArquivo()));
	    stmt.setDate(5, new Date(2004,12,12));
	    stmt.setString(6, f.getObs());
	    stmt.setString(7, f.getFotoNome());
	    stmt.setString(8, f.getContenttype());
	    stmt.setInt(9, f.getIdAlbumAlbum());
	   
	    f.setIdFoto(id);

	    //executa o codigo SQL
	    stmt.executeUpdate();
	    stmt.close();
	}

	public void update(Foto foto) throws SQLException {
		String sql = "update foto set descricao=?, valor=?, arquivo=?, data_upload=?, obs=?, foto_nome=?, contenttype=?, id_album_album=? where id_foto=?";
		
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, foto.getDescricao());
			stmt.setDouble(2,foto.getValor());
			stmt.setBytes(3,this.convertInputStreamToByteArray(foto.getArquivo()));
			stmt.setString(4, foto.getDataUpload());
			stmt.setString(5, foto.getObs());
			stmt.setString(6, foto.getFotoNome());
			stmt.setString(7, foto.getContenttype());
			stmt.setInt(8, foto.getIdAlbumAlbum());
			stmt.setInt(9, foto.getIdFoto());
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Alterado com sucesso");
	}


	
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Foto> findAll() throws SQLException {
		 String sql = "SELECT*FROM foto";
	        PreparedStatement stmt = this.conexao.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        // criando arraylist 
	        List<Foto> Lista = new ArrayList<Foto>();
	        while (rs.next()) {
	            // estanciando 
	            Foto f = new Foto();
	            // pegando os objetos 
               f.setIdFoto(rs.getInt("id_foto"));
	           f.setDescricao(rs.getString("descricao"));
	           f.setValor(rs.getDouble("valor"));
	           f.setArquivo(rs.getBinaryStream("arquivo"));
	           f.setFotoNome(rs.getString("foto_nome"));
	           f.setObs(rs.getString("obs"));
	           f.setContenttype(rs.getString("contenttype"));
	           this.getFile(f.getIdFoto());
	            Lista.add(f);
	        }
	        rs.close();
	        stmt.close();
		return Lista;
	}

	
	public File getFile( int id ){
	    //busca uma conexao com o banco
	    File f = null;
	    try {
	        PreparedStatement ps = conexao.prepareStatement("SELECT id_foto, foto_nome, arquivo, contenttype FROM Foto WHERE id_foto = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if ( rs.next() ){
	            byte [] bytes = rs.getBytes("arquivo");
	            String nome = rs.getString("foto_nome");
	            String content = rs.getString("contenttype");
	            
	            String caminho = "C:\\Users\\HERIVELTON\\git\\PhotoStudioJSP\\PhotoStudioJSP\\WebContent\\images\\";
	            //converte o array de bytes em file
	            f = new File( caminho + nome +id+".jpg");
	            FileOutputStream fos = new FileOutputStream( f);
	            fos.write( bytes );
	            fos.close();
	        }
	        rs.close();
	        ps.close();
	        return f;
	} catch (SQLException ex) {
	ex.printStackTrace();
	}
	catch (IOException ex) {
	ex.printStackTrace();
	}
	return null;
	}
  
    
}

package br.unirn.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unirn.dominio.Bairro;
import br.unirn.dominio.Cidade;
import br.unirn.dominio.Cliente;
import br.unirn.dominio.Contato;
import br.unirn.dominio.Endereco;
import br.unirn.dominio.Estado;
import br.unirn.dominio.Fotografo;


public class FotografoDao{

	private Connection conexao;
	
	public FotografoDao() {
		try {
			this.conexao = Conexao.getConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private int getID(){
		int result = 0;
		String sql = "select nextval('fotografo_id_fotografo_seq')";
		
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
	
public void adicionarUsuario(Fotografo usuario, Endereco endereco, Bairro bairro, Cidade cidade, Estado estado, Contato contato) throws SQLException{
		
		Contato novoContato = new Contato();
		Estado novoEstado = new Estado();
		Cidade novaCidade = new  Cidade();
		Bairro novoBairro = new Bairro();
		Endereco novoEndereco = new Endereco();
		Fotografo novoUsuario = new Fotografo();
		
		EstadoDao estadoDao = new EstadoDao();
		CidadeDao cidadeDao = new CidadeDao();
		BairroDao bairroDao = new BairroDao();
		EnderecoDao enderecoDao = new EnderecoDao();
		ContatoDao contatoDao = new ContatoDao();
		
		boolean estadoexiste = false;
		boolean cidadeexiste = false;
		boolean bairroexiste = false;
		boolean enderecoexiste = false;
		
		// VERIFICANDO SE O ESTADO J� EXISTE NO BANCO
		for (Estado e : estadoDao.findAll()) {

			if (e.getDescricao().equals(estado.getDescricao())) {
				System.out.println("Estado j� existe ! seu id � "
						+ e.getIdEstado());
				novaCidade.setIdEstadoEstado(e);
				estadoexiste = true;
				break;
			}
		}
		// SE O ESTADO N�O EXISTE
		if (estadoexiste == false) {

			System.out.println("Novo Estado Criado");

			novoEstado.setDescricao(estado.getDescricao());
			novaCidade.setIdEstadoEstado(novoEstado);
			try {
				estadoDao.insert(novoEstado);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		// VERIFICANDO SE A CIDADE J� EXISTE NO BANCO
		for (Cidade c : cidadeDao.findAll()) {

			if (c.getDescricao().equals(cidade.getDescricao())) {
				System.out.println("Cidade j� existe ! seu id � "
						+ c.getIdCidade());
				novoBairro.setIdCidadeCidade(c);
				cidadeexiste = true;
				break;
			}
		}
        //SE A CIDADE N�O EXISTE
		if (cidadeexiste == false) {
			novaCidade.setDescricao(cidade.getDescricao());
			novoBairro.setIdCidadeCidade(novaCidade);
			try {
				cidadeDao.insert(novaCidade);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
				
		// VERIFICANDO SE O BAIRRO J� EXISTE NO BANCO
				for (Bairro b : bairroDao.findAll()) {

					if (b.getDescricao().equals(bairro.getDescricao())) {
						System.out.println("Bairro j� existe ! seu id � "
								+ b.getIdBairro());
						novoEndereco.setIdBairroBairro(b);
						bairroexiste = true;
						break;
					}
				}
		
				// SE O BAIRRO N�O EXISTE
				if (bairroexiste == false) {
					novoBairro.setDescricao(bairro.getDescricao());
					novoEndereco.setIdBairroBairro(novoBairro);
					try {
						bairroDao.insert(novoBairro);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}			
		
				// VERIFICANDO SE O ENDERE�O J� EXISTE NO BANCO
				for (Endereco end : enderecoDao.findAll()) {

					if (end.getDescricao().equals(endereco.getDescricao())&&
							end.getCep().equals(endereco.getCep())&&
							end.getNumero().equals(endereco.getNumero())&&
				            end.getComplemento().equals(endereco.getComplemento())) {
						System.out.println("Endere�o j� existe ! seu id � "
								+ end.getIdEndereco());
						novoUsuario.setIdEnderecoEndereco(end);
						enderecoexiste = true;
						break;
					}
				}	
				
		// SE O ENDERE�O N�O EXISTIR		
		if(enderecoexiste==false){		
		novoEndereco.setDescricao(endereco.getDescricao());
		novoEndereco.setCep(endereco.getCep());
		novoEndereco.setComplemento(endereco.getComplemento());
		novoEndereco.setNumero(endereco.getNumero());
		novoUsuario.setIdEnderecoEndereco(novoEndereco);
		try {
			enderecoDao.insert(novoEndereco);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
		
	   //ADICIONANDO NOVO CONTATO	
		novoContato.setTelefone(contato.getTelefone());
		novoContato.setCelular(contato.getCelular());
		novoContato.setEmail(contato.getEmail());
	
		try {
			contatoDao.insert(novoContato);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		// ADICIONANDO USU�RIO
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setCpfFotografo(usuario.getCpfFotografo());
		novoUsuario.setDataNascimento(usuario.getDataNascimento());
		novoUsuario.setLogin(usuario.getLogin());
		novoUsuario.setSenha(usuario.getSenha());
		novoUsuario.setIdContatoContato(novoContato);
	        
                
		 
		try {
			this.insert(novoUsuario);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}


public void insert(Fotografo c) throws SQLException {

	 //PREPARA CONEXÃO
	   int id = getID();
    String slq = "INSERT INTO fotografo(id_fotografo, nome, cpf_fotografo, login, senha, data_nascimento, id_contato_contato, id_endereco_endereco)VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    
   
    PreparedStatement stmt = conexao.prepareStatement(slq);

    // SETANDO OS VALORES
    stmt.setInt(1, id);
    stmt.setString(2, c.getNome());
    stmt.setString(3,c.getCpfFotografo());
    stmt.setString(4,c.getLogin());
    stmt.setString(5, c.getSenha());
    
    stmt.setDate(6, new Date(2004,12,12));
    stmt.setInt(7, c.getIdContatoContato().getIdContato());
    stmt.setInt(8, c.getIdEnderecoEndereco().getIdEndereco());
    c.setIdFotografo(id);
    
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


public List<Fotografo> findAll() throws SQLException {
	 String sql = "SELECT*FROM fotografo";
     PreparedStatement stmt = this.conexao.prepareStatement(sql);
     ResultSet rs = stmt.executeQuery();
     // criando arraylist 
     List<Fotografo> Lista = new ArrayList<Fotografo>();
     while (rs.next()) {
         // estanciando 
         Fotografo c1 = new Fotografo();
         // pegando os objetos 
         c1.setIdFotografo(rs.getInt("id_fotografo"));
         c1.setNome(rs.getString("nome"));
         c1.setLogin(rs.getString("login"));
         c1.setSenha(rs.getString("senha"));
         c1.setCpfFotografo(rs.getString("cpf_fotografo"));
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

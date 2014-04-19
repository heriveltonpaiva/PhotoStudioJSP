package br.unirn.dao;

import java.util.List;

import br.unirn.dominio.Bairro;
import br.unirn.dominio.Cidade;
import br.unirn.dominio.Cliente;
import br.unirn.dominio.Contato;
import br.unirn.dominio.Endereco;
import br.unirn.dominio.Estado;

public class ClienteDao implements GenericDao{

	
/**
 * ESSE METODO ADICIONA UM CLIENTE FAZENDO A VERIFICAÇÃO DE:
 * ESTADO
 * CIDADE
 * BAIRRO
 * ENDEREÇO
 * GARANTINDO QUE NÃO HAVERÁ DUPLICIDADE DE REGISTROS !!!	
 * @param usuario
 * @param endereco
 * @param bairro
 * @param cidade
 * @param estado
 * @param contato
 */
public void adicionarUsuario(Cliente usuario, Endereco endereco, Bairro bairro, Cidade cidade, Estado estado, Contato contato){
		/**
		Contato novoContato = new Contato();
		Estado novoEstado = new Estado();
		Cidade novaCidade = new  Cidade();
		Bairro novoBairro = new Bairro();
		Endereco novoEndereco = new Endereco();
		Cliente novoUsuario = new Cliente();
		
		boolean estadoexiste = false;
		boolean cidadeexiste = false;
		boolean bairroexiste = false;
		boolean enderecoexiste = false;
		
		// VERIFICANDO SE O ESTADO J� EXISTE NO BANCO
		for (Estado e : estadoDao.findAllEstado()) {

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
			estadoDao.insert(novoEstado);
		}

		// VERIFICANDO SE A CIDADE J� EXISTE NO BANCO
		for (Cidade c : cidadeDao.findAllCidade()) {

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
			cidadeDao.insert(novaCidade);

		}
		
				
		// VERIFICANDO SE O BAIRRO J� EXISTE NO BANCO
				for (Bairro b : bairroDao.findAllBairro()) {

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
					bairroDao.insert(novoBairro);
				}			
		
				// VERIFICANDO SE O ENDERE�O J� EXISTE NO BANCO
				for (Endereco end : enderecoDao.findAllEndereco()) {

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
		enderecoDao.insert(novoEndereco);
		}
		
		
	   //ADICIONANDO NOVO CONTATO	
		novoContato.setTelefone(contato.getTelefone());
		novoContato.setCelular(contato.getCelular());
		novoContato.setEmail(contato.getEmail());
	
		contatoDao.insert(novoContato);
		
		
		// ADICIONANDO USU�RIO
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setCpf(usuario.getCpf());
		novoUsuario.setDataNascimento(usuario.getDataNascimento());
		novoUsuario.setLogin(usuario.getLogin());
		novoUsuario.setSenha(usuario.getSenha());
		novoUsuario.setIdContatoContato(novoContato);
	        
                
		 
		clienteDao.insert(novoUsuario);
	**/
	}

@Override
public void insert(Object entity) {
	// TODO Auto-generated method stub
	
}

@Override
public void update(Object entity) {
	// TODO Auto-generated method stub
	
}

@Override
public void delete(Object entity) {
	// TODO Auto-generated method stub
	
}

@Override
public List<Object> findAll() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Object findById(Integer id) {
	// TODO Auto-generated method stub
	return null;
}
	
	
	
}

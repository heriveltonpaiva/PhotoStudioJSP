package br.unirn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unirn.dao.ClienteDao;
import br.unirn.dominio.Bairro;
import br.unirn.dominio.Cidade;
import br.unirn.dominio.Cliente;
import br.unirn.dominio.Contato;
import br.unirn.dominio.Endereco;
import br.unirn.dominio.Estado;
import br.unirn.dominio.Fotografocliente;

/**
 * Servlet implementation class Cliente
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	ClienteDao dao = new ClienteDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
  
    }
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/formCliente.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//TABELA CLIENTE
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Cliente cliente = new Cliente();
        
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setLogin(login);
        cliente.setSenha(senha);
        //TABELA ENDERE�O
        
        String end = request.getParameter("end");
        int numero = Integer.parseInt(request.getParameter("num"));
        String cep = request.getParameter("cep");
        String compl = request.getParameter("complemento");
        
        Endereco endereco = new Endereco();
        
        endereco.setCep(cep);
        endereco.setNumero(numero);
        endereco.setComplemento(compl);
        endereco.setDescricao(end);
        
        // TABELA BAIRRO
        
        String bairro = request.getParameter("bairro");
        
        Bairro b = new Bairro();
        b.setDescricao(bairro);
        
        //TABELA CIDADE
        String cidade = request.getParameter("cidade");
        
        Cidade c = new Cidade();
        c.setDescricao(cidade);
        
        //ESTADO
        String estado = request.getParameter("estado");
        
        Estado e = new Estado();
        
        e.setDescricao(estado);
        
        //TABELA CONTATO
        String tel = request.getParameter("tel"); 
        String cel = request.getParameter("cel");
String email = request.getParameter("email");

        Contato contato = new  Contato();
        
        contato.setCelular(cel);
        contato.setEmail(email);
        contato.setTelefone(tel);
        
        Fotografocliente fc = new Fotografocliente();
        
        HttpSession sessao = request.getSession(false);
        
        int id_fotografo =  (Integer) sessao.getAttribute("id_usuario");
        
        fc.setIdFotografocliente(id_fotografo);
        
       
			try {
				dao.adicionarUsuario(cliente, endereco, b, c, e, contato, fc);
			} catch (SQLException e1) {
				System.out.println("Erro:"+e1.getMessage()+"Causa"+e1.getCause());
				e1.printStackTrace();
			}
	
	
	List<Cliente> listaCliente;
	try {
		listaCliente = dao.findAll();
		request.setAttribute("listaCliente", listaCliente);	        
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/ListClienteServlet");
	dispatcher.forward(request, response);
	 
	}
}

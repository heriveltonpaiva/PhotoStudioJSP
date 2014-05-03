package br.unirn.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unirn.dao.ClienteDao;
import br.unirn.dao.Conexao;
import br.unirn.dominio.Bairro;
import br.unirn.dominio.Cidade;
import br.unirn.dominio.Cliente;
import br.unirn.dominio.Contato;
import br.unirn.dominio.Endereco;
import br.unirn.dominio.Estado;
import br.unirn.dominio.Fotografo;

/**
 * Servlet implementation class Cliente
 */
@WebServlet("/ListClienteServlet")
public class ListClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	ClienteDao dao = new ClienteDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClienteServlet() {
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
		
		List<Cliente> listaCliente;
		try {
			listaCliente = dao.findAll();
			request.setAttribute("listaCliente", listaCliente);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/listCliente.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	 
	}
}

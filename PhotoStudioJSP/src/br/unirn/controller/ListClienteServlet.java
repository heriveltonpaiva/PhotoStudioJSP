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

import br.unirn.dao.ClienteDao;
import br.unirn.dominio.Cliente;

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
		String id = request.getParameter("id");
		String op = request.getParameter("op");
		
		
		
		if(op==null){
		List<Cliente> listaCliente;
		try {
			listaCliente = dao.findAllCliente();
			request.setAttribute("listaCliente", listaCliente);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/listCliente.jsp");
		dispatcher.forward(request, response);
		}else if(op.equals("e")){
			
			try {
				dao.delete(Integer.parseInt(id));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/listCliente.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	 
	}
}

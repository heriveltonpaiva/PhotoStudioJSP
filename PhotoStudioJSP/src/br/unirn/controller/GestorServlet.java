package br.unirn.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unirn.dao.GestorDao;
import br.unirn.dominio.Gestor;

/**
 * Servlet implementation class GestorServlet
 */
@WebServlet(urlPatterns = {"/GestorServlet"})  
public class GestorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    GestorDao dao = new GestorDao();
	
	
    public GestorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {

	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher("pages/gestor/acesso.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Gestor gestor = new Gestor();
		
		gestor.setLogin(login);
		gestor.setSenha(senha);
		
		try {
			dao.update(gestor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

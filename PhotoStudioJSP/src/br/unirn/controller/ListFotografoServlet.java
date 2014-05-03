package br.unirn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unirn.dao.FotografoDao;
import br.unirn.dominio.Bairro;
import br.unirn.dominio.Cidade;
import br.unirn.dominio.Cliente;
import br.unirn.dominio.Contato;
import br.unirn.dominio.Endereco;
import br.unirn.dominio.Estado;
import br.unirn.dominio.Fotografo;

/**
 * Servlet implementation class FotografoController
 */
@WebServlet("/ListFotografoServlet")
public class ListFotografoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	FotografoDao fotografoDao = new FotografoDao();
	
	
    public ListFotografoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Fotografo> listaFotografo;
		try {
			listaFotografo = fotografoDao.findAll();
			request.setAttribute("listaFotografo", listaFotografo);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/gestor/listFotografo.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
			
	}
		
	

}

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

import br.unirn.dao.FotografoDao;
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
		
		String id = request.getParameter("id");
		String op = request.getParameter("op");
		
		
		
		if(op==null){
		List<Fotografo> listaFotografo;
		try {
			listaFotografo = fotografoDao.findAllFotografo();
			request.setAttribute("listaFotografo", listaFotografo);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/gestor/listFotografo.jsp");
		dispatcher.forward(request, response);
	
	}else if(op.equals("e")){
		
		try {
			fotografoDao.delete(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/gestor/formFotografo.jsp");
		dispatcher.forward(request, response);		
	}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
			
	}
		
	

}

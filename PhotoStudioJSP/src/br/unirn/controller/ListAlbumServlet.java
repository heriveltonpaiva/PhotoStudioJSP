package br.unirn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unirn.dao.AlbumDao;
import br.unirn.dominio.Album;
import br.unirn.dominio.Cliente;

/**
 * Servlet implementation class AlbumController
 */
@WebServlet("/ListAlbumServlet")
public class ListAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AlbumDao dao = new AlbumDao();
	
    public ListAlbumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String op = request.getParameter("op");
		
		request.setAttribute("op", op);
		
		if(op==null){
		List<Album> listaAlbum;
		try {
			listaAlbum = dao.findAll();
			request.setAttribute("listaAlbum", listaAlbum);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/listAlbum.jsp");
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
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/listAlbum.jsp");
			dispatcher.forward(request, response);
		}else if(op.equals("a")){
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/formAlbum.jsp");
			try {
				Album ab = dao.findById(Integer.parseInt(id));
				
				request.setAttribute("desc", ab.getDescricao());
				request.setAttribute("obser", ab.getObs());
				
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			dispatcher.forward(request, response);
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}

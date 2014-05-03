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
import br.unirn.dao.FotoDao;
import br.unirn.dominio.Album;
import br.unirn.dominio.Cliente;
import br.unirn.dominio.Foto;

/**
 * Servlet implementation class AlbumController
 */
@WebServlet("/ListAlbumClienteServlet")
public class ListAlbumClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	FotoDao dao = new FotoDao();
	
    public ListAlbumClienteServlet() {
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
		
		List<Foto> listaFotos;
		try {
			listaFotos = dao.findAll();

			request.setAttribute("listaFotos", listaFotos);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/cliente/listAlbum.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}

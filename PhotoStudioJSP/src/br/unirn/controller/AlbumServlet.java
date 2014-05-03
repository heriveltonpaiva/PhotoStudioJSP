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
import javax.servlet.http.HttpSession;

import br.unirn.dao.AlbumDao;
import br.unirn.dominio.Album;
import br.unirn.dominio.Cliente;

/**
 * Servlet implementation class AlbumController
 */
@WebServlet("/AlbumServlet")
public class AlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AlbumDao dao = new AlbumDao();
	
    public AlbumServlet() {
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
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/formAlbum.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String descricao = request.getParameter("descricao");
		String obs = request.getParameter("obs");
		
		 HttpSession sessao = request.getSession(false);
	        
	        int id_fotografo =  (Integer) sessao.getAttribute("id_usuario");
		
		
		Album album = new Album();
		
		album.setDescricao(descricao);
		album.setData(new Date());
		album.setObs(obs);
		
		
		try {
			dao.insert(album, id_fotografo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Album> listaAlbum;
		try {
			listaAlbum = dao.findAll();
			request.setAttribute("listaAlbum", listaAlbum);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListAlbumServlet");
		dispatcher.forward(request, response);
		}
		
	

}
